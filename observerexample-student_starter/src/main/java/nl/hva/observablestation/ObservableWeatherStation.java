package nl.hva.observablestation;

import nl.hva.sensors.*;

import java.util.ArrayList;

public class ObservableWeatherStation implements Subject { //TODO implement interfaces as necessary

    //TODO add a structure to hold the sensors, observers and the current weather
    private ArrayList<Observer> observers;
    private ArrayList<Sensor> sensors;

    public ObservableWeatherStation() {
        this.observers = new ArrayList<>();
        this.sensors = new ArrayList<>();
    }

    public void checkSensors() {
        //TODO get readings from sensors and format in a suitable way (see output of main)
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
        for (Observer observer : observers) {
            observer.update(0, 0, 0);
        }
    }
}