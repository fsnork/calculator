package com.github.fsnork.calculator.operation;

public enum OperationName {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    FACTORIAL("!"),
    SQUARE("sq"),
    DEGREE("^"),
    LOGE("loge"),
    LOGN("logn"),
    ROOT("rt"),
    PERCENT("%")
    ;

    private final String operationName;

    OperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }
}
