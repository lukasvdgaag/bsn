package nl.hva.factories;

import nl.hva.components.HardDrive;
import nl.hva.components.SSD;
import nl.hva.components.Storage;
import nl.hva.components.StorageType;

public abstract class AbstractComputerComponentFactory implements ComputerComponentFactory {

    @Override
    public Storage[] selectStorage(StorageType... type) {
        Storage[] storage = new Storage[type.length];
        for (int i = 0; i < type.length; i++) {
            if (type[i] == StorageType.SolidStateDrive) {
                storage[i] = new SSD();
            } else {
                storage[i] = new HardDrive();
            }
        }
        return storage;
    }

}
