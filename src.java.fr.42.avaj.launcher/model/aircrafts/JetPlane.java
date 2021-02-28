package model.aircrafts;

import model.Aircraft;
import model.Coordinates;
import model.Flyable;
import model.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
