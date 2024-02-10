package nl.hva.state;

public class OpenState implements State {

    @Override
    public String lockDoor() {
        return Messages.DOOR_CANNOT_PERFORM_THIS_ACTION;
    }

    @Override
    public String closeDoor() {
        return Messages.CLOSED_STATE_MESSAGE;
    }

    @Override
    public String openDoor() {
        return Messages.DOOR_CANNOT_PERFORM_THIS_ACTION;
    }

    @Override
    public String armDoor() {
        return Messages.DOOR_CANNOT_PERFORM_THIS_ACTION;
    }

    @Override
    public String toString() {
        return Messages.OPEN_STATE_MESSAGE;
    }
}
