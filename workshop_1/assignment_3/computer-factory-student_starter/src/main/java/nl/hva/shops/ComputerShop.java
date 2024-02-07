package nl.hva.shops;

import nl.hva.computers.Computer;
import nl.hva.computers.ComputerTypes;

public abstract class ComputerShop {

    protected Computer buildComputer(String computerType) {
        if (computerType.equals(ComputerTypes.BASIC_COMPUTER)) {
            return this.buildBasicComputer();
        } else if (computerType.equals(ComputerTypes.GAMING_COMPUTER)) {
            return this.buildGamingComputer();
        }
        return null;
    }

    protected Computer prepareComputer(String computerType) {
        Computer computer = buildComputer(computerType);
        System.out.println("--- Making an " + computer.getName() + " ---");
        computer.prepare();
        computer.bootUpTest();
        computer.burnInTest();
        computer.box();
        return computer;
    }

    protected abstract Computer buildBasicComputer();

    protected abstract Computer buildGamingComputer();

}
