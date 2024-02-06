package nl.hva.observablestation;

import nl.hva.sensors.Sensor;

import java.util.List;

public interface Observer {

    void update(List<Sensor> sensors);

    String getName();

}
