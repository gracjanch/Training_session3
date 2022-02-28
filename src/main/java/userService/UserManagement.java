package userService;

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
            case "1" -> System.out.println("option 1");
            case "2" -> System.out.println("option 2");
            case "3" -> System.out.println("option 3");
        }
    }
    private String userChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
