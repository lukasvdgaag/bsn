package nl.hva.aircraft;

import nl.hva.state.*;

public class AircraftDoor {

    private final String id;
    private State state;

    public AircraftDoor(String id) {
        this.id = id;
        this.state = new OpenState();
    }

    public String openDoor() {
        String message = state.openDoor();
        if (message.equals(Messages.OPEN_STATE_MESSAGE)) {
            setState(getOpenState());
        } else if (message.equals(Messages.SLIDE_DEPLOYED)) {
            setState(getDeployedState());
        }
        return message;
    }

    public String closeDoor() {
        String message = state.closeDoor();
        if (message.equals(Messages.CLOSED_STATE_MESSAGE)) {
            setState(getClosedState());
        }
        return message;
    }

    public String armDoor() {
        String message = state.armDoor();
        if (message.equals(Messages.ARMED_STATE_MESSAGE)) {
            setState(getArmedState());
        }
        return message;
    }

    public String lockDoor() {
        String message = state.lockDoor();
        if (message.equals(Messages.LOCKED_STATE_MESSAGE)) {
            setState(getLockedState());
        }
        return message;
    }

    void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getOpenState() {
        return new OpenState();
    }

    public State getClosedState() {
        return new ClosedState();
    }

    public State getLockedState() {
        return new LockedState();
    }

    public State getArmedState() {
        return new ArmedState();
    }

    public State getDeployedState() {
        return new SlideDeployedState();
    }

    public String toString() {
        StringBuilder status = new StringBuilder();
        status.append("\nnl.hva.aircraft.Aircraft Door: " + id);
        status.append("\n");
        status.append("nl.hva.state.State is " + state + "\n");
        return status.toString();
    }


}
