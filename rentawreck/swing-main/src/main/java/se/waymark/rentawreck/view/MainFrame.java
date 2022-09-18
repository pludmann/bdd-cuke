package se.waymark.rentawreck.view;

import javax.swing.*;

import se.waymark.rentawreck.controller.MainController;

import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private MainController controller;
    private JTextField numberOfCars;

    public MainFrame(MainController controller) {
        this.controller = controller;
        controller.addView(this);
        addMenu(controller);
        createMainFrame();
        controller.showAvailableCars();
    }

    public void showAvailableCars(int availableCars) {
        clearContentPanel();

        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addAvailableCarsLeadingText(contentPanel);
        addAvailableCarsLabel(availableCars, contentPanel);

        add(contentPanel);
    }

    private void addAvailableCarsLeadingText(JPanel contentPanel) {
        JLabel availableCarsLabel = new JLabel();
        availableCarsLabel.setText("Available compact cars: ");
        contentPanel.add(availableCarsLabel);
    }

    private void addAvailableCarsLabel(int availableCars, JPanel contentPanel) {
        JLabel availableCarsValueLabel = new JLabel();
        availableCarsValueLabel.setName("availableCarsValueLabel");
        availableCarsValueLabel.setText("" + availableCars);
        contentPanel.add(availableCarsValueLabel);
    }

    public void showCreateCars() {
        clearContentPanel();

        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addNumberOfCarsLabel(contentPanel);
        addNumberOfCarsField(contentPanel);
        addCreateButton(contentPanel);

        add(contentPanel);
    }

    private void addNumberOfCarsLabel(JPanel contentPanel) {
        JLabel availableCarsLabel = new JLabel();
        availableCarsLabel.setText("Number of cars: ");
        contentPanel.add(availableCarsLabel);
    }

    private void addNumberOfCarsField(JPanel contentPanel) {
        numberOfCars = new JTextField("            ");
        numberOfCars.setName("numberOfCars");
        contentPanel.add(numberOfCars);
    }

    private void addCreateButton(JPanel contentPanel) {
        JButton createButton = new JButton("Create cars");
        createButton.setName("createButton");
        createButton.setActionCommand("createCars");
        createButton.addActionListener(controller);
        contentPanel.add(createButton);
    }

    public Component add(JPanel component) {
        super.add(component);
        component.revalidate();
        return component;
    }

    public JTextField getNumberOfCarsTextField() {
        return numberOfCars;
    }

    private void addMenu(ActionListener controller) {
        JMenuBar menu = new JMenuBar();
        setMenuLayout(menu);
        addMenuItems(controller, menu);
        setJMenuBar(menu);
    }

    private void createMainFrame() {
        setSize(400, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setMenuLayout(JMenuBar menu) {
        LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT);
        menu.setLayout(layoutManager);
    }

    private void addMenuItems(ActionListener controller, JMenuBar menu) {
        menu.add(getFileMenu(controller));
        menu.add(getRentMenu(controller));
        menu.add(getToolsMenu(controller));
    }

    private JMenu getFileMenu(ActionListener controller) {
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.setActionCommand("exit");
        exit.addActionListener(controller);
        file.add(exit);

        return file;
    }

    private JMenuItem getRentMenu(ActionListener controller) {
        JMenuItem rent = new JMenuItem("Rent");
        rent.setName("rentMenuItem");
        rent.setActionCommand("rentCar");
        rent.addActionListener(controller);

        return rent;
    }

    private JMenu getToolsMenu(ActionListener controller) {
        JMenu tools = new JMenu("Tools");
        JMenuItem addCars = new JMenuItem("Add cars");
        addCars.setName("showAddCarsForm");
        addCars.setActionCommand("showAddCarsForm");
        addCars.addActionListener(controller);
        tools.add(addCars);

        return tools;
    }

    private void clearContentPanel() {
        getContentPane().removeAll();
    }
}
