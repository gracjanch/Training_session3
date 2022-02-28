package userService;

public class UserInformation {
    public static void initialInfo() {
        System.out.println("===== Weather Application =====");
    }

    public static void options() {
        System.out.println("[1] - Add location.");
        System.out.println("[2] - Display all locations.");
        System.out.println("[3] - Show weather.");
        System.out.println("[4] - Quit.");
        System.out.print("Choose an option: ");
    }
}
