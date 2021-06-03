package com.github.fsnork.calculator.service;

import com.github.fsnork.calculator.global.Calc;
import com.github.fsnork.calculator.operation.OperationContainer;
import com.github.fsnork.calculator.operation.PreparedOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        BigDecimal number1;
        BigDecimal number2;
        input = input.replace("\"", "");
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
            number1 = new BigDecimal(numbers[0]);
            opId = input.replace(numbers[0], "");
            System.out.println(opId);
            preparedOp = new PreparedOp(number1, operationContainer.retrieveOperation(opId));
        } else if (i == 2) {
            number1 = new BigDecimal(numbers[0]);
            number2 = new BigDecimal(numbers[1]);
            System.out.println("two numbers");
            opId = input.replace(numbers[0], "").replace(numbers[1], "");
            if (number2.compareTo(new BigDecimal(0)) < 0 && opId.isEmpty()) {
                opId = "+";
            }
            System.out.println(opId);
            preparedOp = new PreparedOp(number1, number2, operationContainer.retrieveOperation(opId));
        } else {
            System.out.println("Incorrect input.");
        }
        return preparedOp;
    }

    public String getOpId() {
        return opId;
    }

    public boolean isInteger(BigDecimal number) {
        return number.stripTrailingZeros().scale() <= 0;
    }
}
