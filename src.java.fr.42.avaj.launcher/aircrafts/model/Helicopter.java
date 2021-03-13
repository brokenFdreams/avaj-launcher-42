package aircrafts.model;

import aircrafts.Aircraft;
import aircrafts.Coordinates;
import aircrafts.Flyable;
import tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        if (weatherTower == null) {
            System.out.println(toString() + ": I cannot contact the Weather Tower!");
        } else {
            String weather = weatherTower.getWeather(coordinates);
            if (weather.equals("SUN")) {
                coordinates = new Coordinates(longitude + 10, latitude, height + 2);
                System.out.println(toString() + ": This is hot.");
            } else if (weather.equals("RAIN")) {
                coordinates = new Coordinates(longitude + 5, latitude, height);
                System.out.println(toString() + ": Damn rain. I can't see.");
            } else if (weather.equals("FOG")) {
                coordinates = new Coordinates(longitude + 1, latitude, height);
                System.out.println(toString() + ": Damn fog. I can't see.");
            } else if (weather.equals("SNOW")) {
                coordinates = new Coordinates(longitude, latitude, height - 12);
                System.out.println(toString() + ": My rotor is going to freeze!");
            }
        }
        if (coordinates.getHeight() <= 0) {
            System.out.println(toString() + " landing.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
