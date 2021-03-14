package aircrafts;

import tower.WeatherTower;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}
