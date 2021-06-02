package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class SubtractOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public SubtractOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        BigDecimal result = preparedOp.getNumber1().subtract(preparedOp.getNumber2());
        System.out.println(result);
    }
}
