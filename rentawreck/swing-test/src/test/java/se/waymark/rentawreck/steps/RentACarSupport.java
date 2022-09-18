package se.waymark.rentawreck.steps;

import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.*;

import se.waymark.rentawreck.controller.MainController;
import se.waymark.rentawreck.view.MainFrame;

public class RentACarSupport {

    public void createCars(int availableCars) {
        FrameFixture window = getFrameFixture();
        try {
            JMenuItemFixture addCars = window.menuItem("showAddCarsForm");
            addCars.click();

            JTextComponentFixture numberOfCars = window.textBox("numberOfCars");
            numberOfCars.setText("" + availableCars);

            JButtonFixture createButton = window.button("createButton");
            createButton.click();
        } finally {
            window.cleanUp();
        }
    }

    public void rentACar() {
        FrameFixture window = getFrameFixture();
        try {
            JMenuItemFixture rentMenuItem = window.menuItem("rentMenuItem");
            rentMenuItem.click();
        } finally {
            window.cleanUp();
        }
    }

    public int getAvailableNumberOfCars() {
        FrameFixture window = getFrameFixture();
        try {
            JLabelFixture availableCarLabel = window.label("availableCarsValueLabel");
            String availableCars = availableCarLabel.text();

            return Integer.parseInt(availableCars);
        } finally {
            window.cleanUp();
        }
    }

    private FrameFixture getFrameFixture() {
        MainFrame frame = GuiActionRunner.execute(new GuiQuery<MainFrame>() {
            protected MainFrame executeInEDT() {
                MainController controller = new MainController();
                return new MainFrame(controller);
            }
        });
        return new FrameFixture(frame);
    }
}