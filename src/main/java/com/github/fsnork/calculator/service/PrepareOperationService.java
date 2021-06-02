package com.github.fsnork.calculator.service;

import com.github.fsnork.calculator.global.Calc;
import com.github.fsnork.calculator.operation.OperationContainer;
import com.github.fsnork.calculator.operation.PreparedOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PrepareOperationService {

    private final Calc calc;
    private String opId;

    @Autowired
    public PrepareOperationService(Calc calc) {
        this.calc = calc;
        System.out.println("service");
    }

    public PreparedOp prepareOp(String input, OperationContainer operationContainer) {
        System.out.println("preparing op");
        PreparedOp preparedOp = null;
        String[] numbers = new String[2];
        String operation;
        Pattern pat= Pattern.compile("[-]?[0-9]+([.][0-9]+)?");
        Matcher matcher=pat.matcher(input);
        System.out.println("found " + matcher.groupCount());
        int i = 0;
        while (matcher.find()) {
            numbers[i] = matcher.group(0);
            System.out.println("first number " + numbers[i]);
            i++;
        }
        System.out.println("i = " + i);
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        if (i == 1) {
            operation = input.replace(numbers[0], "");
            opId = operation;
            System.out.println(operation);
            preparedOp = new PreparedOp(Double.parseDouble(numbers[0]),
                    operationContainer.retrieveOperation(operation));
        } else if (i == 2) {
            System.out.println("two numbers");
            operation = input.replace(numbers[0], "").replace(numbers[1], "");

            opId = operation;
            System.out.println(operation);
            preparedOp = new PreparedOp(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]),
                    operationContainer.retrieveOperation(operation));
        } else {
            System.out.println("Incorrect input.");
        }
        return preparedOp;
    }

    public String getOpId() {
        return opId;
    }
}
