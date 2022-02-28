package userService;

import location.Location;
import location.LocationManagement;

import java.util.Scanner;

public class UserManagement {
    public void start() {
        UserInformation.initialInfo();

        while (true) {
            UserInformation.options();
            String choice = userChoice();
            if(choice.equals("4")) {
                break;
            }
            selectOption(choice);
        }
    }

    private void selectOption(String choice) {
        switch (choice) {
            case "1" -> addLocation();
            case "2" -> System.out.println("option 2");
            case "3" -> System.out.println("option 3");
        }
    }
    private String userChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void addLocation() {
        Location location = new Location(
                UserInformation.getInfoFromUser("Type coordinates"),
                UserInformation.getInfoFromUser("Type city"),
                UserInformation.getInfoFromUser("Type region"),
                UserInformation.getInfoFromUser("Type country")
        );

        LocationManagement locationManagement = new LocationManagement();
        locationManagement.addLocation(location);
    }

}
