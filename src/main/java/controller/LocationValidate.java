package controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationValidate {

    public static String validCity(){
        boolean x;
        String cityLocation;
        do{
            cityLocation = new Scanner(System.in).nextLine();
            Pattern nameCityPattern = Pattern.compile("[a-z]{2}+");
            Matcher m = nameCityPattern.matcher(cityLocation);
            x = m.find();
            if(x == true){
                return cityLocation;
            }
            System.out.println("Incorrect data. Write city name again.");
        }while(x != true);
        return cityLocation;
    }




}
