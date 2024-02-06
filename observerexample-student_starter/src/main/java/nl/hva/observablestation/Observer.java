package nl.hva.observablestation;

public interface Observer {

    void update(float temp, float humidity, float pressure);

    String getName();

}
