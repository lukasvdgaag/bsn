package nl.hva.computers;

import nl.hva.factories.ComputerComponentFactory;

public class GamingComputer extends Computer{

    public GamingComputer(ComputerComponentFactory factory) {
        super(factory);
    }

    @Override
    public void prepare() {

    }
}
