package factory;

import aircrafts.Coordinates;
import aircrafts.Flyable;
import aircrafts.model.Baloon;
import aircrafts.model.Helicopter;
import aircrafts.model.JetPlane;
import exception.AircraftException;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "Helicopter":
                return new Helicopter(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            case "Baloon":
                return new Baloon(name, coordinates);
            default:
                throw new AircraftException("Invalid aircraft type - " + type);
        }
    }
}
