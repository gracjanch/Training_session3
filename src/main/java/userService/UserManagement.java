package userService;

public class UserManagement {
    public void start() {
        UserInformation.initialInfo();
        UserInformation.options();
    }

    public void selectOption(String choice) {
        switch (choice) {
            case "1" -> System.out.println("option 1");
            case "2" -> System.out.println("option 2");
            case "3" -> System.out.println("option 3");
        }
    }
    public String userChoice() {
        return "";
    }

}
