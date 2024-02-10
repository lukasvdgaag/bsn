package nl.hva.state;

public class ArmedState implements State{

    @Override
    public String lockDoor() {
        return Messages.LOCKED_STATE_MESSAGE;
    }

    @Override
    public String closeDoor() {
        return Messages.CLOSED_STATE_MESSAGE;
    }

    @Override
    public String openDoor() {
        return Messages.SLIDE_DEPLOYED;
    }

    @Override
    public String armDoor() {
        return Messages.DOOR_CANNOT_PERFORM_THIS_ACTION;
    }

    @Override
    public String toString() {
        return Messages.ARMED_STATE_MESSAGE;
    }
}
