package tower;

import aircrafts.Flyable;

import java.util.LinkedList;
import java.util.List;

public class Tower {
    public final List<Flyable> aircrafts = new LinkedList<>();

    public void register(Flyable flyable) {
        if (!aircrafts.contains(flyable)) {
            aircrafts.add(flyable);
            System.out.println("Tower says: " +
                    flyable.toString() +
                    " registered to weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        aircrafts.remove(flyable);
        System.out.println("Tower says: " +
                flyable.toString() +
                " unregistered from weather tower.");
    }

    public void conditionsChanged() {
        for (Flyable aircraft: aircrafts) {
            aircraft.updateConditions();
        }
    }
}
