package com.github.fsnork.calculator.operation;

import com.github.fsnork.calculator.service.PrepareOperationService;
import com.google.common.collect.ImmutableMap;

import static com.github.fsnork.calculator.operation.OperationName.*;

public class OperationContainer {
    private final ImmutableMap<String, Operation> map;
    private final Operation unknownOp;

    public OperationContainer(PrepareOperationService prepareOperationService) {
        map = ImmutableMap.<String, Operation>builder().
                put(ADD.getOperationName(), new AddOp(prepareOperationService)).
                put(SUBTRACT.getOperationName(), new SubtractOp(prepareOperationService)).
                build();
        unknownOp = new UnknownOp(prepareOperationService);
    }

    public Operation retrieveOperation(String opId) {
        return map.getOrDefault(opId, unknownOp);
    }
}