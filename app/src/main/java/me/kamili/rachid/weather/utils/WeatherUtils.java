package me.kamili.rachid.weather.utils;

public class WeatherUtils {

    //description from : http://weather.gfc.state.ga.us/Info/WXexp.aspx
    public static String getCloudinessDesc(int cloudiness, long ts) {
        boolean isDay = TimeUtils.isDay(ts);
        if (cloudiness < 10)
            return isDay ? "Sunny" : "Clear";
        if (cloudiness < 20)
            return isDay ? "Sunny to Mostly Sunny" : "Fair";
        if (cloudiness < 30)
            return "Mostly Sunny";
        if (cloudiness < 50)
            return "Partly Sunny";
        if (cloudiness < 70)
            return "Mostly Cloudy";
        return "Cloudy";
    }

    public static String getDescription(double highTemp) {
        return "High " + (int) celsiusToFahrenheit(highTemp) + "°F.";
    }

    public static double celsiusToFahrenheit(double temp){
        return 32 + (temp * 9 / 5);
    }
}
