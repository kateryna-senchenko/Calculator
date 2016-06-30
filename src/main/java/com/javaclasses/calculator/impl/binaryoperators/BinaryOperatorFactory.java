package com.javaclasses.calculator.impl.binaryoperators;

import static com.javaclasses.calculator.impl.binaryoperators.Priority.HIGH;
import static com.javaclasses.calculator.impl.binaryoperators.Priority.LOW;
import static com.javaclasses.calculator.impl.binaryoperators.Priority.MEDIUM;

/**
 * Factory to create instances of binary operators
 */
public class BinaryOperatorFactory {

    /**
     * Creates an instance of a binary operator
     * @param symbol - character of the required binary operator
     * @return instance of the required binary operator
     */
    public static BinaryOperator getBinaryOperator(char symbol){

        switch (symbol){

            case '+': return new Plus(LOW);

            case '-': return new Minus(LOW);

            case '*': return new MultiplicationOperator(MEDIUM);

            case '/': return new DivisionOperator(MEDIUM);

            case '^': return new Power(HIGH);

            default: return null;
        }

    }
}
