package nl.hva.observablestation;

import nl.hva.sensors.Sensor;

import java.util.ArrayList;

public class WeatherDisplay implements Observer { //TODO implement interfaces as necessary
    private String name;
    private ArrayList<Sensor> sensors;

    public WeatherDisplay(String name) {
        this.name = name;
        this.sensors = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(float temp, float humidity, float pressure) {

    }
}
