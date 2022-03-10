package view;

import service.LocationService;

import java.util.Scanner;

public class UserManagement {
    private static final UserInformation info = new UserInformation();

    public void start() {
        info.initialInfo();

        while (true) {
            info.options();
            String choice = UserValidate.validUserChoice();
            if(choice.equals("4")) {
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
                info.displayAllLocations();
                break;
            case "3":
                info.displayWeather();
                break;
        }
    }
    public static String userChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
