package nl.hva.factories;

import nl.hva.components.*;

public class AmdGamingComputerComponentFactory extends AbstractComputerComponentFactory{

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
        return new AmdFastProcessor();
    }

    @Override
    public MotherBoard selectMotherBoard() {
        return new AmdMotherBoard();
    }

    @Override
    public Memory[] selectMemory() {
        return new Memory[]{new EightGBRam(), new EightGBRam(), new EightGBRam(), new EightGBRam()};
    }

    @Override
    public GraphicsCard selectGraphicsCard() {
        return new AmdGraphicsCard();
    }
}
