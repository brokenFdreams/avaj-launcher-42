package model;

public class Aircraft {
    private static long idCounter = 0;
    private final long id;
    private final String name;
    private final Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) {
        id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return idCounter++;
    }
}
