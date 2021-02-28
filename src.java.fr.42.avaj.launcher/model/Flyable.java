package model;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}
