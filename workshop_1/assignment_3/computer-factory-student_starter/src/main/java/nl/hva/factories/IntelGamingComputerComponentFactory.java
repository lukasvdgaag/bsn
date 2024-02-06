package nl.hva.factories;

import nl.hva.components.*;

public class IntelGamingComputerComponentFactory implements ComputerComponentFactory{


    @Override
    public ComputerCase selectCase() {
        return new GamingComputerCase();
    }

    @Override
    public PowerSupply selectPowerSupply() {
        return new GamingPowerSupply();
    }

    @Override
    public Processor selectProcessor() {
        return new IntelFastProcessor();
    }

    @Override
    public MotherBoard selectMotherBoard() {
        return new AmdMotherBoard();
    }

    @Override
    public Memory[] selectMemory() {
        return new Memory[0];
    }

    @Override
    public GraphicsCard selectGraphicsCard() {
        return null;
    }

    @Override
    public Storage[] selectStorage(StorageType... type) {
        return new Storage[0];
    }
}
