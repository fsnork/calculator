package com.github.fsnork.calculator.operation;

import java.math.BigDecimal;

public class PreparedOp {

    private BigDecimal number1;
    private BigDecimal number2;
    private Operation operation;

    public PreparedOp(BigDecimal number1, BigDecimal number2, Operation operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public BigDecimal getNumber1() {
        return number1;
    }

    public BigDecimal getNumber2() {
        return number2;
    }

    public Operation getOperation() {
        return operation;
    }

    public PreparedOp(BigDecimal number1, Operation operation) {
        this.number1 = number1;
        this.operation = operation;
    }

}
