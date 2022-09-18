package se.waymark.rentawreck.model.dao;

import se.waymark.rentawreck.model.entity.Car;

public interface CarDAO {

    public void add(Car car);

    Car findAvailableCar();

    int getNumberOfAvailableCars();    
}
