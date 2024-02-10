package nl.hva.state;

public class ClosedState implements State{

    @Override
    public String lockDoor() {
        return Messages.DOOR_CANNOT_PERFORM_THIS_ACTION;
    }

    @Override
    public String closeDoor() {
        return Messages.DOOR_CANNOT_PERFORM_THIS_ACTION;
    }

    @Override
    public String openDoor() {
        return Messages.OPEN_STATE_MESSAGE;
    }

    @Override
    public String armDoor() {
        return Messages.ARMED_STATE_MESSAGE;
    }

    @Override
    public String toString() {
        return Messages.CLOSED_STATE_MESSAGE;
    }
}
