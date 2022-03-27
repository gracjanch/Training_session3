package validation;

import view.UserInformation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidate {
    private static final UserInformation info = new UserInformation();

    public String validateUserChoice() {
        boolean isValid;
        String value;

        do {
            value = info.getInfoFromUser("Choose an option: ");

            Pattern choicePattern = Pattern.compile("[1-6]");
            Matcher m = choicePattern.matcher(value);
            isValid = m.find();
        } while (!isValid);

        return value;
    }
}
