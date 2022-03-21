package view;

import validation.UserValidate;

import java.util.Scanner;

public class UserManagement {
    private static final UserInformation info = new UserInformation();
    private static final UserValidate userValidate = new UserValidate();

    public void start() {
        info.initialInfo();

        while (true) {
            info.options();
            String choice = userValidate.validateUserChoice();
            if(choice.equals("5")) {
                break;
            }
            selectOption(choice);
        }
    }

    private void selectOption(String choice) {
        switch (choice) {
            case "1":
                info.addLocation();
                break;
            case "2":
                info.deleteLocation();
                break;
            case "3":
                info.displayAllLocations();
                break;
            case "4":
                info.displayWeatherForEachCity();
                break;
        }
    }
}
