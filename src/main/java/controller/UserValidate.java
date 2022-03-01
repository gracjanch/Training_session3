package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static controller.UserManagement.userChoice;

public class UserValidate {

    public static String validUserChoice(){
        boolean properlyValue;
        String userChoice;
        do{
            userChoice = userChoice();
            Pattern userChoicePattern = Pattern.compile("[1-4]{1}");
            Matcher m = userChoicePattern.matcher(userChoice);
            properlyValue = m.find();
            if(properlyValue == true){
                return userChoice;
            }
            System.out.println("Incorrect data. Write again.");
        }while(properlyValue != true);
        return userChoice;
    }
}
