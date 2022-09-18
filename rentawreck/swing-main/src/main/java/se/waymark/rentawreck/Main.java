package se.waymark.rentawreck;

import se.waymark.rentawreck.controller.MainController;
import se.waymark.rentawreck.view.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController();
        new MainFrame(controller);
    }
}