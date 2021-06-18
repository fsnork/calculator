package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class DivideOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public DivideOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    @Override
    public void execute(PreparedOp preparedOp) {
        if (preparedOp.getNumber2().compareTo(new BigDecimal(0)) == 0) {
            System.out.println("Division by 0!");
        } else {
            BigDecimal result = preparedOp.getNumber1().divide(preparedOp.getNumber2()).stripTrailingZeros();
            System.out.println(result);
        }
    }
}
