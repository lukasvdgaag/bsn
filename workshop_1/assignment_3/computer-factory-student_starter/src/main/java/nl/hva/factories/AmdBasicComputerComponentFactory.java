package nl.hva.factories;

import nl.hva.components.*;

public class AmdBasicComputerComponentFactory extends AbstractComputerComponentFactory{

    @Override
    public ComputerCase selectCase() {
        return new BasicComputerCase();
    }

    @Override
    public PowerSupply selectPowerSupply() {
        return new BasicPowerSupply();
    }

    @Override
    public Processor selectProcessor() {
        return new AmdProcessor();
    }

    @Override
    public MotherBoard selectMotherBoard() {
        return new AmdMotherBoard();
    }

    @Override
    public Memory[] selectMemory() {
        return new Memory[]{new FourGBRam(), new FourGBRam()};
    }

    @Override
    public GraphicsCard selectGraphicsCard() {
        return null;
    }
}
