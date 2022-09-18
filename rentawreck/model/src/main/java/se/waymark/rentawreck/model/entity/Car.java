package se.waymark.rentawreck.model.entity;

public class Car {
    private boolean rented;

    public void rent() {
        rented = true;
    }

    public boolean isRented() {
        return rented;
    }
}
