package model.aircrafts;

import model.Aircraft;
import model.Coordinates;
import model.Flyable;
import model.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
