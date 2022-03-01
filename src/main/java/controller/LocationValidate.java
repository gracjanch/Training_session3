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

    public static String validCoordinate(){
        boolean properlyValue;
        String cityCoordinate;
        boolean firstCoordBoolean;
        boolean secondCoordBoolean;
        do{
            cityCoordinate = new Scanner(System.in).nextLine();
            Pattern nameCityPattern = Pattern.compile("[-]*+[0-9]+[x]+[-]*[0-9]+");
            Matcher m = nameCityPattern.matcher(cityCoordinate);
            properlyValue = m.find();
            String[] coordinates = cityCoordinate.split("x");
            Integer firstCoord = Integer.valueOf(coordinates[0]);
            Integer secondCoord = Integer.valueOf(coordinates[1]);
            firstCoordBoolean= firstCoord >= -90 && firstCoord <= 90;
            secondCoordBoolean = secondCoord >= -180 && secondCoord <= 180;

            if(properlyValue == true && firstCoordBoolean && secondCoordBoolean){
                return cityCoordinate;
            }
            System.out.println("Incorrect data. Write coordinates again.");
        }while(properlyValue != true || firstCoordBoolean != true || secondCoordBoolean != true);
        return cityCoordinate;
    }


}
