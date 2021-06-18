package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class DegreeOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public DegreeOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        BigDecimal result;
        double number = preparedOp.getNumber1().doubleValue();
        double degree = preparedOp.getNumber2().doubleValue();
        if (number < 0 && degree % 1 != 0) {
            result = BigDecimal.valueOf(Math.pow(number * -1, degree)).multiply(new BigDecimal(-1));
        } else {
            result = BigDecimal.valueOf(Math.pow(number, degree)).stripTrailingZeros();
        }
        System.out.println(result);
    }
}
