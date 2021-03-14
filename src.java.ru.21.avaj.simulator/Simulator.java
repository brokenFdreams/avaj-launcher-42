import aircrafts.Flyable;
import exception.AircraftException;
import exception.SimulationException;
import factory.AircraftFactory;
import logger.Logger;
import tower.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {

    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.println("Usage: ");
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                String line = reader.readLine();
                if (line != null) {
                    int count = Integer.parseInt(line);
                    WeatherTower weatherTower = new WeatherTower();

                    if (count <= 0) {
                        throw new SimulationException("Invalid number of times the simulation is run");
                    }
                    while ((line = reader.readLine()) != null) {
                        String[] aircraftParams = line.split(" ");
                        Flyable flyable = AircraftFactory.newAircraft(
                                aircraftParams[0],
                                aircraftParams[1],
                                Integer.parseInt(aircraftParams[2]),
                                Integer.parseInt(aircraftParams[3]),
                                Integer.parseInt(aircraftParams[4]));
                        flyable.registerTower(weatherTower);
                    }
                    for (int i = 0; i < count; i++) {
                        weatherTower.changeWeather();
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("File - " + args[0] + " not found");
            } catch (IOException e) {
                System.err.println("Read file - " + args[0] + " exception");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Invalid file - " + args[0]);
            } catch (SimulationException | AircraftException e) {
                System.err.println(e.getMessage());
            } finally {
                Logger.close();
            }
        }
    }
}