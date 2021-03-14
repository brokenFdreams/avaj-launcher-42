package aircrafts.model;

import aircrafts.Aircraft;
import aircrafts.Coordinates;
import aircrafts.Flyable;
import logger.Logger;
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
            Logger.log(toString() + ": I cannot contact the Weather Tower!");
        } else {
            String weather = weatherTower.getWeather(coordinates);
            switch (weather) {
                case "SUN":
                    coordinates = new Coordinates(longitude + 10, latitude, height + 2);
                    Logger.log(toString() + ": This is hot.");
                    break;
                case "RAIN":
                    coordinates = new Coordinates(longitude + 5, latitude, height);
                    Logger.log(toString() + ": Damn rain. I can't see.");
                    break;
                case "FOG":
                    coordinates = new Coordinates(longitude + 1, latitude, height);
                    Logger.log(toString() + ": Damn fog. I can't see.");
                    break;
                case "SNOW":
                    coordinates = new Coordinates(longitude, latitude, height - 12);
                    Logger.log(toString() + ": My rotor is going to freeze!");
                    break;
            }
        }
        if (coordinates.getHeight() <= 0) {
            Logger.log(toString() + " landing.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
