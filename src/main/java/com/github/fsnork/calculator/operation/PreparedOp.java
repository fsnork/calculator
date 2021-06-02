package com.github.fsnork.calculator.operation;

public class PreparedOp {

    private Double number1;
    private Double number2;
    private Operation operation;

    public PreparedOp(Double number1, Double number2, Operation operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public Double getNumber1() {
        return number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public Operation getOperation() {
        return operation;
    }

    public PreparedOp(Double number1, Operation operation) {
        this.number1 = number1;
        this.operation = operation;
    }

}
