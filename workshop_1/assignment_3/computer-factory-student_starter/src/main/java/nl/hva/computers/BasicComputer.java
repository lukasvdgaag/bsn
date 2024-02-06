package nl.hva.computers;

import nl.hva.factories.ComputerComponentFactory;

public class BasicComputer extends Computer {

    public BasicComputer(ComputerComponentFactory factory) {
        super(factory);
    }

    @Override
    public void prepare() {

    }
}
