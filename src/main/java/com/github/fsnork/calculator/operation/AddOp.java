package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

public class AddOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public AddOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    public void execute(PreparedOp preparedOp) {
        System.out.println(preparedOp.getNumber1() + preparedOp.getNumber2());
    }
}
