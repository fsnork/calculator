package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class FactorialOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public FactorialOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        BigDecimal result = new BigDecimal(1);
        BigDecimal number = preparedOp.getNumber1();
        if (number.compareTo(BigDecimal.ZERO) > 0 && number.stripTrailingZeros().scale() <= 0) {
            for (int i = 1; i <= number.intValue(); i++) {
                result = result.multiply(new BigDecimal(i));
            }
            System.out.println(result.stripTrailingZeros());
        } else if (number.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(result.stripTrailingZeros());
        } else {
            System.out.println("Incorrect input.");
        }
    }
}
