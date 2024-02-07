package nl.hva.computers;

import nl.hva.components.StorageType;
import nl.hva.factories.ComputerComponentFactory;

public class GamingComputer extends Computer{

    public GamingComputer(ComputerComponentFactory factory) {
        super(factory);
        this.name = "Intel Gaming PC";
    }

    @Override
    public void prepare() {
        super.prepare();

        storage = computerComponentFactory.selectStorage(StorageType.SolidStateDrive, StorageType.HardDrive);
    }

}
