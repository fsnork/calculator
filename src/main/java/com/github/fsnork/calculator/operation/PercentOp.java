package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class PercentOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public PercentOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        double number = preparedOp.getNumber1().doubleValue();
        double percents = preparedOp.getNumber2().doubleValue();
        if (percents >= 0) {
            BigDecimal result = BigDecimal.valueOf(number * percents / 100);
            System.out.println(result.stripTrailingZeros());
        } else {
            System.out.println("Incorrect input.");
        }
    }
}
