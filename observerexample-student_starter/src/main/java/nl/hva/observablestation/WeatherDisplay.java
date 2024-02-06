package nl.hva.observablestation;

import nl.hva.sensors.Sensor;

import java.util.List;

public class WeatherDisplay implements Observer {

    private final String name;

    public WeatherDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(List<Sensor> sensors) {
        System.out.println(getName());
        System.out.println("Current weather is:");
        sensors.forEach(System.out::println);
    }

    @Override
    public String getName() {
        return name;
    }
}
