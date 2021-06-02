package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

public class SubtractOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public SubtractOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        System.out.println(preparedOp.getNumber1() - preparedOp.getNumber2());
    }
}
