package aircrafts;

public abstract class Aircraft {
    private static long idCounter = 0;
    private final long id;
    private final String name;
    protected Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) {
        id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return ++idCounter;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + name + "(" + id + ")";
    }
}
