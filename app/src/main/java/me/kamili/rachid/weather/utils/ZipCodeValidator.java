package me.kamili.rachid.weather.utils;

public class ZipCodeValidator {

    private static String REG_EX = "^[0-9]{5}(?:-[0-9]{4})?$";

    public static boolean isValidZipCode(String zip) {
        if (isValidDecimalNumber(zip) && zip.matches(REG_EX)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidDecimalNumber(String zip) {
        try {
            Long.valueOf(zip);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
