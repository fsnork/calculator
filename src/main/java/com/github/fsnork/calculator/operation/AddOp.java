package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;

import java.math.BigDecimal;

public class AddOp implements Operation {

    private final PrepareOperationService prepareOperationService;

    public AddOp(PrepareOperationService prepareOperationService) {
        this.prepareOperationService = prepareOperationService;
    }

    public void execute(PreparedOp preparedOp) {
        BigDecimal result = preparedOp.getNumber1().add(preparedOp.getNumber2()).stripTrailingZeros();
        System.out.println(result);
    }
}
