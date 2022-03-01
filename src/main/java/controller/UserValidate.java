package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static controller.UserManagement.userChoice;

public class UserValidate {

    public static String validUserChoice(){
        boolean properlyValue;
        String uChoice;
        do{
            uChoice = UserManagement.userChoice();
            Pattern userChoicePattern = Pattern.compile("[1-4]{1}");
            Matcher m = userChoicePattern.matcher(uChoice);
            properlyValue = m.find();
            if(properlyValue){
                break;
            }
            System.out.println("Incorrect data. Write again.");
        }while(!properlyValue);
        return uChoice;
    }
}
