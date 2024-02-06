package nl.hva.shops;

import nl.hva.computers.Computer;
import nl.hva.computers.GamingComputer;
import nl.hva.factories.IntelGamingComputerComponentFactory;

public class AMDComputerShop extends ComputerShop {

    @Override
    protected Computer buildComputer(String computerType) {
        return new GamingComputer(new IntelGamingComputerComponentFactory());
    }
}
