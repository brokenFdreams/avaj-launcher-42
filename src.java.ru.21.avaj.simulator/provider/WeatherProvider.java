package provider;

import aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private static final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private static final Random random = new Random();

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int coordinatesSum = coordinates.getLongitude() +
                coordinates.getLatitude() +
                coordinates.getHeight() +
                random.nextInt(2);
        return weather[coordinatesSum % 4];
    }
}
