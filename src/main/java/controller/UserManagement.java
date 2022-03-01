package controller;

import view.UserInformation;

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
            case "1":
                LocationManagement.addLocation();
                break;
            case "2":
                UserInformation.displayAllLocations();
                break;
            case "3":
                UserInformation.displayWeather();
                break;
        }
    }
    private String userChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
