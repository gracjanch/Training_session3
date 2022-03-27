package service;

import validation.UserValidate;
import view.UserInformation;

public class UserService {
    private static final UserInformation info = new UserInformation();
    private static final UserValidate userValidate = new UserValidate();

    public void start() {
        info.initialInfo();

        while (true) {
            info.options();
            String choice = userValidate.validateUserChoice();
            if(choice.equals("6")) {
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
                info.updateLocation();
                break;
            case "3":
                info.deleteLocation();
                break;
            case "4":
                info.displayAllLocations();
                break;
            case "5":
                info.displayWeatherForEachCity();
                break;

        }
    }
}
