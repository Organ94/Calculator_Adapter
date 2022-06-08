package Calculator;

import Interfaces.Ints;

public class IntsCalculator implements Ints {

    protected final Calculator target;

    public IntsCalculator() {
        this.target = new Calculator();
    }

    @Override
    public int sum(int arg0, int arg1) {
        return calculator(arg0, arg1, "SUM");
    }

    @Override
    public int mult(int arg0, int arg1) {
        return calculator(arg0, arg1, "MULT");
    }

    @Override
    public int pow(int arg0, int arg1) {
        return calculator(arg0, arg1, "POW");
    }

    private int calculator(int arg0, int arg1, String operation) {
        return (int) target.newFormula()
                .addOperand(arg0)
                .addOperand(arg1)
                .calculate(Calculator.Operation.valueOf(operation))
                .result();
    }
}
