package tower;

import aircrafts.Coordinates;
import weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider()
                .getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionsChanged();
    }
}
