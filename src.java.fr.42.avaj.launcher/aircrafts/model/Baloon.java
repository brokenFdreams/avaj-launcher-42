package aircrafts.model;

import aircrafts.Aircraft;
import aircrafts.Coordinates;
import aircrafts.Flyable;
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
            System.out.println(this.toString() + ": I cannot contact the Weather Tower!");
        } else {
            String weather = weatherTower.getWeather(coordinates);
            if (weather.equals("SUN")) {
                coordinates = new Coordinates(longitude + 2, latitude, height + 4);
                System.out.println(toString() + ": Let's enjoy the good weather and take some pics.");
            } else if (weather.equals("RAIN")) {
                coordinates = new Coordinates(longitude, latitude, height - 5);
                System.out.println(toString() + ": Damn you rain! You messed up my baloon.");
            } else if (weather.equals("FOG")) {
                coordinates = new Coordinates(longitude, latitude, height - 3);
                System.out.println(toString() + ": I can't see through fog.");
            } else if (weather.equals("SNOW")) {
                coordinates = new Coordinates(longitude, latitude, height - 15);
                System.out.println(toString() + ": It's snowing. We're gonna crash.\n");
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
