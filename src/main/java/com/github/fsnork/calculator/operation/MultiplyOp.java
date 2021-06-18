package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class MultiplyOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public MultiplyOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        BigDecimal result = preparedOp.getNumber1().multiply(preparedOp.getNumber2()).stripTrailingZeros();
        System.out.println(result);
    }
}
