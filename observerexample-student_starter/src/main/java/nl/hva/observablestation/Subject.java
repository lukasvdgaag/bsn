package nl.hva.observablestation;

public interface Subject {

    void checkSensors();

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    int getNumberOfObservers();

}
