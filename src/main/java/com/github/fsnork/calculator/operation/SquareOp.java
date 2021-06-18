package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class SquareOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public SquareOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        BigDecimal result = preparedOp.getNumber1().multiply(preparedOp.getNumber1()).stripTrailingZeros();
        System.out.println(result);
    }
}
