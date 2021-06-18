package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class LogNOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public LogNOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        double base = preparedOp.getNumber1().doubleValue();
        double number = preparedOp.getNumber2().doubleValue();
        if (base > 0 && base != 1 && number > 0) {
            BigDecimal result = BigDecimal.valueOf(Math.log(number) / Math.log(base)).stripTrailingZeros();
            System.out.println(result);
        } else {
            System.out.println("Incorrect input.");
        }
    }
}
