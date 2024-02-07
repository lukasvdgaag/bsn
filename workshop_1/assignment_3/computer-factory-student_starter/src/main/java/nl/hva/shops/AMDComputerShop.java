package nl.hva.shops;

import nl.hva.computers.BasicComputer;
import nl.hva.computers.Computer;
import nl.hva.computers.GamingComputer;
import nl.hva.factories.AmdBasicComputerComponentFactory;
import nl.hva.factories.AmdGamingComputerComponentFactory;

public class AMDComputerShop extends ComputerShop {

    @Override
    protected Computer buildBasicComputer() {
        return new BasicComputer(new AmdBasicComputerComponentFactory());
    }

    @Override
    protected Computer buildGamingComputer() {
        return new GamingComputer(new AmdGamingComputerComponentFactory());
    }
}
