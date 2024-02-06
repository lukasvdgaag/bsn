package nl.hva.shops;

import nl.hva.computers.BasicComputer;
import nl.hva.computers.Computer;
import nl.hva.factories.IntelBasicComputerComponentFactory;

public class IntelComputerShop extends ComputerShop {

    @Override
    protected Computer buildComputer(String computerType) {
        return new BasicComputer(new IntelBasicComputerComponentFactory());
    }
}
