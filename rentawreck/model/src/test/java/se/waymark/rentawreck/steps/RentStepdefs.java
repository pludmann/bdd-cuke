package se.waymark.rentawreck.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import se.waymark.rentawreck.model.dao.CarDAO;
import se.waymark.rentawreck.model.dao.InMemoryCarDAO;
import se.waymark.rentawreck.model.entity.Car;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RentStepdefs {
    private CarDAO carDatabase;
    @Given("there are {int} cars available for rental")
    public void there_are_cars_available_for_rental(int availableCars) throws Throwable {
        carDatabase = new InMemoryCarDAO();
        for (int i = 0; i < availableCars; i++) {
            Car car = new Car();
            carDatabase.add(car);
        }
    }

    @When("I rent one")
    public void I_rent_one() throws Throwable {
        Car car = carDatabase.findAvailableCar();
        car.rent();
    }

    @Then("there will only be {int} cars available for rental")
    public void there_will_only_be_cars_available_for_rental(int expectedAvailableCars) throws Throwable {
        int actualAvailableCars = carDatabase.getNumberOfAvailableCars();
        assertThat(actualAvailableCars, is(expectedAvailableCars));
    }
}
