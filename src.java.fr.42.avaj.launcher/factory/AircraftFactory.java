package factory;

import model.Coordinates;
import model.Flyable;
import model.aircrafts.Baloon;
import model.aircrafts.Helicopter;
import model.aircrafts.JetPlane;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Helicopter")) {
            return new Helicopter(name, coordinates);
        } else if (type.equals("JetPlane")) {
            return new JetPlane(name, coordinates);
        } else if (type.equals("Baloon")) {
            return new Baloon(name, coordinates);
        } else {
            System.out.println("There's no type " + type);
            return null;
        }
    }
}
