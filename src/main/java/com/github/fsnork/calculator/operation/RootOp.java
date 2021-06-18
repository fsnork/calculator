package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class RootOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public RootOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        double number = preparedOp.getNumber1().doubleValue();
        double indicator = preparedOp.getNumber2().doubleValue();
        BigDecimal result;
        if (number >= 0 && indicator > 0) {
            result = BigDecimal.valueOf(Math.pow(number, 1.0 / indicator));
            System.out.println(result.stripTrailingZeros());
        } else if (number < 0 && !isEven(indicator)) {
            result = BigDecimal.valueOf(Math.pow(-number, 1.0 / indicator)).multiply(BigDecimal.valueOf(-1));
            System.out.println(result.stripTrailingZeros());
        } else {
            System.out.println("Incorrect input.");
        }
    }

    private static boolean isEven(double number) {
        return number % 2 == 0;
    }
}
