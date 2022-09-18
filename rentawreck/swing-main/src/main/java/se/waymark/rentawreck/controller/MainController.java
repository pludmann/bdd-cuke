package se.waymark.rentawreck.controller;

import se.waymark.rentawreck.view.MainFrame;
import se.waymark.rentawreck.model.dao.CarDAO;
import se.waymark.rentawreck.model.dao.InMemoryCarDAO;
import se.waymark.rentawreck.model.entity.Car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {
    private CarDAO carDAO = new InMemoryCarDAO();
    private MainFrame view;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();

        if (actionCommand.equalsIgnoreCase("showAddCarsForm")) {
            showAddCarsForm();
        } else if (actionCommand.equalsIgnoreCase("createCars")) {
            createCars();
        } else if (actionCommand.equalsIgnoreCase("rentCar")) {
            rentCar();
        } else if (actionCommand.equalsIgnoreCase("exit")) {
            exit();
        } else {
            System.out.println("Unknown action command: " + actionCommand);
        }
    }

    private void showAddCarsForm() {
        view.showCreateCars();
    }

    private void createCars() {
        JTextField textField = view.getNumberOfCarsTextField();
        String carsToCreateString = textField.getText().trim();
        int carsToCreate = Integer.parseInt(carsToCreateString);
        for (int i = 0; i < carsToCreate; i++) {
            Car car = new Car();
            carDAO.add(car);
        }
        int numberOfAvailableCars = carDAO.getNumberOfAvailableCars();
        view.showAvailableCars(numberOfAvailableCars);
    }

    public void showAvailableCars() {
        int numberOfAvailableCars;
        try {
            numberOfAvailableCars = carDAO.getNumberOfAvailableCars();
        } catch (RuntimeException e) {
            numberOfAvailableCars = 0;
        }
        view.showAvailableCars(numberOfAvailableCars);
    }

    private void rentCar() {
        int numberOfAvailableCars;
        try {
            carDAO.findAvailableCar().rent();
            numberOfAvailableCars = carDAO.getNumberOfAvailableCars();
        } catch (RuntimeException e) {
            numberOfAvailableCars = 0;
        }
        view.showAvailableCars(numberOfAvailableCars);
    }

    private void exit() {
        System.exit(0);
    }

    public void addView(MainFrame view) {
        this.view = view;
    }
}