package nl.hva.shops;

import nl.hva.computers.BasicComputer;
import nl.hva.computers.Computer;
import nl.hva.computers.GamingComputer;
import nl.hva.factories.IntelBasicComputerComponentFactory;
import nl.hva.factories.IntelGamingComputerComponentFactory;

public class IntelComputerShop extends ComputerShop {

    @Override
    protected Computer buildBasicComputer() {
        return new BasicComputer(new IntelBasicComputerComponentFactory());
    }

    @Override
    protected Computer buildGamingComputer() {
        return new GamingComputer(new IntelGamingComputerComponentFactory());
    }

}
