package com.github.fsnork.calculator.operation;

public enum OperationName {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    FACTORIAL("!"),
    SQUARE("sq")
    ;

    private final String operationName;

    OperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }
}
