package nl.hva.observablestation;

import nl.hva.sensors.*;

import java.util.ArrayList;
import java.util.List;

public class ObservableWeatherStation implements Subject {

    private final List<Observer> observers;
    private final List<Sensor> sensors;

    public ObservableWeatherStation() {
        this.observers = new ArrayList<>();
        this.sensors = new ArrayList<>();

        sensors.add(new RainGauge());
        sensors.add(new Thermometer());
        sensors.add(new Hygrometer());
        sensors.add(new Anemometer());
    }

    public void checkSensors() {
        sensors.forEach(Sensor::takeMeasurement);
        this.notifyObservers();
    }

    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public int getNumberOfObservers() {
        return this.observers.size();
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(sensors));
    }
}