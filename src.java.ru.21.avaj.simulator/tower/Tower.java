package tower;

import aircrafts.Flyable;
import logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    public final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            Logger.log("Tower says: " +
                    flyable.toString() +
                    " registered to weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logger.log("Tower says: " +
                flyable.toString() +
                " unregistered from weather tower.");
    }

    public void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
