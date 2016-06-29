package com.javaclasses.calculator.impl;


import com.javaclasses.calculator.impl.binaryoperators.BinaryOperator;
import com.javaclasses.calculator.impl.functions.ClosureContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * Contains stacks for operands and operators to calculate mathematical expressions
 */
public class EvaluationContext {

    private static final Logger log = LoggerFactory.getLogger(EvaluationContext.class);

    private Deque<Double> operandStack  = new ArrayDeque<>();
    private Deque<BinaryOperator> operatorStack = new ArrayDeque<>();

    private EvaluationContext parent;
    private ClosureContext closure;


    public EvaluationContext(){
        this.parent = null;
        this.closure = null;
    }

    public EvaluationContext(EvaluationContext parent, ClosureContext closure){
        this.parent = parent;
        this.closure = closure;
    }


    /**
     * Pushes number into the operand stack
     * @param number - floating point value
     */
    public void pushNumber(double number){

        operandStack.push(number);

        if (log.isInfoEnabled()) {
            log.info(number + " was added to the operand stack");
        }
    }

    /**
     * Pushes operator into the operator stack
     * @param operator - binary operator
     */
    public void pushOperator(BinaryOperator operator) {

        // pops all operators with higher or equal priority
        while (operatorStack.size() > 0 && operator.compareTo(operatorStack.peek()) <= 0) {

            BinaryOperator currentOperation = operatorStack.pop();
            double rightOperand = operandStack.pop();
            double leftOperand = operandStack.pop();

            if (log.isDebugEnabled()) {
                log.debug("Operation " + currentOperation.getClass() + " is performing on " +
                leftOperand + " and " + rightOperand);
            }

            operandStack.push(currentOperation.execute(leftOperand, rightOperand));

            if (log.isInfoEnabled()) {
                log.info(currentOperation.execute(leftOperand, rightOperand) + " was added to the operand stack");
            }
        }

        operatorStack.push(operator);

        if (log.isInfoEnabled()) {
            log.info(operator.getClass() + " was added to the operand stack");
        }
    }

    /**
     * Pops all operators from the operator stack
     */
    public void popAllOperators(){

        while(operatorStack.size() > 0) {

            BinaryOperator currentOperation = operatorStack.pop();
            double rightOperand = operandStack.pop();
            double leftOperand = operandStack.pop();

            if (log.isDebugEnabled()) {
                log.debug("Operation " + currentOperation.getClass() + " is performing on " +
                        leftOperand + " and " + rightOperand);
            }

            operandStack.push(currentOperation.execute(leftOperand, rightOperand));

            if (log.isInfoEnabled()) {
                log.info(currentOperation.execute(leftOperand, rightOperand) + " was added to the operand stack");
            }
        }

    }


    /**
     * Calculates result
     * @return calculated value
     */
    public double getResult(){

        if(closure != null){

            return closure.getFunction().execute((Double[]) getAllOperands().toArray(new Double[getAllOperands().size()]));
        }

        popAllOperators();

        if(operandStack.size() != 1){
            log.error("Evaluation of the mathematical expression failed");
            throw new IllegalStateException("Evaluation of the mathematical expression failed");
        }

        if (log.isInfoEnabled()) {
            log.info("Current context is closing with result " + operandStack.peek());
        }
        return operandStack.pop();
    }

    /**

     * Pops all operands from the operand stack
     * @return List of operands
     */
    private List<Double> getAllOperands(){

        List<Double> operands = new ArrayList<>();

        while(!operandStack.isEmpty()){
            operands.add(operandStack.pop());
        }

        if (log.isInfoEnabled()) {
            log.info("List of operands: " + operands.toString());
        }

        return operands;
    }

}


