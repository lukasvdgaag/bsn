package nl.hva.computers;

import nl.hva.components.StorageType;
import nl.hva.factories.ComputerComponentFactory;

public class BasicComputer extends Computer {

    public BasicComputer(ComputerComponentFactory factory) {
        super(factory);
        this.name = "Intel Basic PC";
    }

    @Override
    public void prepare() {
        super.prepare();

        storage = computerComponentFactory.selectStorage(StorageType.HardDrive);
    }
}
