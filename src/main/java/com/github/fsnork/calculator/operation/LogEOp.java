package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class LogEOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public LogEOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        double number = preparedOp.getNumber1().doubleValue();
        if (number > 0) {
            BigDecimal result = BigDecimal.valueOf(Math.log(number)).stripTrailingZeros();
            System.out.println(result);
        } else {
            System.out.println("Incorrect input.");
        }

    }
}
