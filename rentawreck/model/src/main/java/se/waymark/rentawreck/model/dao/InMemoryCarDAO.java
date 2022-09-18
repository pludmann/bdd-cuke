package se.waymark.rentawreck.model.dao;

import java.util.List;
import java.util.LinkedList;

import se.waymark.rentawreck.model.entity.Car;

public class InMemoryCarDAO implements CarDAO {
    private static List<Car> cars;

    public InMemoryCarDAO() {
        if (cars == null) {
            cars = new LinkedList<Car>();
        }
    }

    @Override
    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public Car findAvailableCar() {
        for (Car car : cars) {
            if (!car.isRented()) {
                return car;
            }
        }
        throw new RuntimeException("No car available");
    }

    @Override
    public int getNumberOfAvailableCars() {
        int availableCars = 0;
        for (Car car : cars) {
            if (!car.isRented()) {
                availableCars++;
            }
        }
        return availableCars;
    }
}
