package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class ExponentaOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public ExponentaOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        double number = preparedOp.getNumber1().doubleValue();
        BigDecimal result = BigDecimal.valueOf(Math.exp(number));
        System.out.println(result.stripTrailingZeros());
    }
}
