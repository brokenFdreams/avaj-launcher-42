package provider;

import aircrafts.Coordinates;

public class WeatherProvider {
    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private static final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int coordinatesSum = coordinates.getLongitude() +
                coordinates.getLatitude() +
                coordinates.getHeight();

        return weather[coordinatesSum % 4];
    }
}
