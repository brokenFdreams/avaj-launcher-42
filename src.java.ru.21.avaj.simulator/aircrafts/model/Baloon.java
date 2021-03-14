package aircrafts.model;

import aircrafts.Aircraft;
import aircrafts.Coordinates;
import aircrafts.Flyable;
import logger.Logger;
import tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
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
                    coordinates = new Coordinates(longitude + 2, latitude, height + 4);
                    Logger.log(toString() + ": Let's enjoy the good weather and take some pics.");
                    break;
                case "RAIN":
                    coordinates = new Coordinates(longitude, latitude, height - 5);
                    Logger.log(toString() + ": Damn you rain! You messed up my baloon.");
                    break;
                case "FOG":
                    coordinates = new Coordinates(longitude, latitude, height - 3);
                    Logger.log(toString() + ": I can't see through fog.");
                    break;
                case "SNOW":
                    coordinates = new Coordinates(longitude, latitude, height - 15);
                    Logger.log(toString() + ": It's snowing. We're gonna crash.");
                    break;
                default:
                    Logger.log(toString() + ": I cannot contact the Weather Tower!");
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
