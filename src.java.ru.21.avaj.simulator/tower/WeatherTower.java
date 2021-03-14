package tower;

import aircrafts.Coordinates;
import provider.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider()
                .getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionsChanged();
    }
}
