package de.commands;

import de.math.Calculator;
import de.math.CalculatorMemento;

public class MultCommand implements Command{
    private double value;
    private CalculatorMemento memento;
    @Override
    public void parse(String[] tokens) {
        this.value = Double.valueOf(tokens[1]);
    }

    @Override
    public void execute() {
        memento = Calculator.getInstance().getMemento();
        Calculator.getInstance().mult(value);
    }

    @Override
    public boolean isQuery() {
        return false;
    }

    @Override
    public void undo() {
        Calculator.getInstance().setMemento(memento);
    }
}
