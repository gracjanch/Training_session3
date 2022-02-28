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
            case "1" -> UserInformation.addLocation();
            case "2" -> UserInformation.displayAllLocations();
            case "3" -> System.out.println("option 3");
        }
    }
    private String userChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
