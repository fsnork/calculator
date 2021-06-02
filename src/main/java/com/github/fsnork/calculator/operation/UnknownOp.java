package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

public class UnknownOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public UnknownOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }


    public void execute(PreparedOp preparedOp) {
        System.out.println("There's no such operation :(");
    }
}
