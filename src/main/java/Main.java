import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.start();
    }
}
