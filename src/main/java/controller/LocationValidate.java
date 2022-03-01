package controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationValidate {

    public static String validCity(){
        boolean properlyValue;
        String cityLocation;
        do{
            cityLocation = new Scanner(System.in).nextLine();
            Pattern nameCityPattern = Pattern.compile("[a-z]{2}+");
            Matcher m = nameCityPattern.matcher(cityLocation);
            properlyValue = m.find();
            if(properlyValue){
               break;
            }
            System.out.println("Incorrect data. Write city name again.");
        }while(!properlyValue);
        return cityLocation;
    }

    public static String validCoordinate() {
        boolean properlyValue;
        String cityCoordinate;
        boolean firstCoordBoolean = false;
        boolean secondCoordBoolean = false;
        do {
            cityCoordinate = new Scanner(System.in).nextLine();
            Pattern nameCityPattern = Pattern.compile("[-]*+[0-9]+[x]+[-]*[0-9]+");
            Matcher m = nameCityPattern.matcher(cityCoordinate);
            properlyValue = m.find();
            if(!properlyValue){
                System.out.println("Incorrect data. Write coordinates again.");
                continue;
            }

            String[] coordinates = cityCoordinate.split("x");
            Integer firstCoord = Integer.valueOf(coordinates[0]);
            Integer secondCoord = Integer.valueOf(coordinates[1]);
            firstCoordBoolean = firstCoord >= -90 && firstCoord <= 90;
            secondCoordBoolean = secondCoord >= -180 && secondCoord <= 180;

            if (firstCoordBoolean && secondCoordBoolean) {
                break;
            }
            System.out.println("Incorrect data. Write coordinates again.");
        } while (!properlyValue && !firstCoordBoolean && !secondCoordBoolean);
        return cityCoordinate;
    }





}
