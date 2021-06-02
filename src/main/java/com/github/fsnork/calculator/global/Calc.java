package com.github.fsnork.calculator.global;

import com.github.fsnork.calculator.operation.OperationContainer;
import com.github.fsnork.calculator.operation.PreparedOp;
import com.github.fsnork.calculator.service.PrepareOperationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Calc implements CommandLineRunner {

    private static final String START_MESSAGE = "Calculator! Examples of input: \"2.3+4.55\"; \"56sq\"";
    private final OperationContainer operationContainer;

    public Calc() {
        this.operationContainer = new OperationContainer(new PrepareOperationService(this));
    }

    @Override
    public void run(String... args) {
        main(args);
    }

    public void main(String[] args) {
        System.out.println(START_MESSAGE);
        PrepareOperationService prepareOperationService = new PrepareOperationService(this);
        System.out.println(args[0]);
        PreparedOp preparedOp = prepareOperationService.prepareOp(args[0], operationContainer);
        operationContainer.retrieveOperation(prepareOperationService.getOpId()).execute(preparedOp);
    }
}
