package aircrafts.model;

import aircrafts.Aircraft;
import aircrafts.Coordinates;
import aircrafts.Flyable;
import logger.Logger;
import tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
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
                    coordinates = new Coordinates(longitude, latitude + 10, height + 2);
                    Logger.log(toString() + ": I love SUN.");
                    break;
                case "RAIN":
                    coordinates = new Coordinates(longitude, latitude + 5, height);
                    Logger.log(toString() + ": It's raining. Better watch out for lightings.");
                    break;
                case "FOG":
                    coordinates = new Coordinates(longitude, latitude + 1, height);
                    Logger.log(toString() + ": There's fog. Better watch out for lightings.");
                    break;
                case "SNOW":
                    coordinates = new Coordinates(longitude, latitude, height - 7);
                    Logger.log(toString() + ": OMG! Winter is coming!");
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
