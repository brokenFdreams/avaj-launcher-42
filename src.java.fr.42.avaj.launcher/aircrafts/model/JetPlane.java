package aircrafts.model;

import aircrafts.Aircraft;
import aircrafts.Coordinates;
import aircrafts.Flyable;
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
            System.out.println(toString() + ": I cannot contact the Weather Tower!");
        } else {
            String weather = weatherTower.getWeather(coordinates);
            if (weather.equals("SUN")) {
                coordinates = new Coordinates(longitude, latitude + 10, height + 2);
                System.out.println(toString() + ": I love SUN.");
            } else if (weather.equals("RAIN")) {
                coordinates = new Coordinates(longitude, latitude + 5, height);
                System.out.println(toString() + ": It's raining. Better watch out for lightings.");
            } else if (weather.equals("FOG")) {
                coordinates = new Coordinates(longitude, latitude + 1, height);
                System.out.println(toString() + ": There's fog. Better watch out for lightings.");
            } else if (weather.equals("SNOW")) {
                coordinates = new Coordinates(longitude, latitude, height - 7);
                System.out.println(toString() + ": OMG! Winter is coming!\n");
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
