package com.javaclasses.calculator.impl.parsers;


import com.javaclasses.calculator.impl.State;

import java.text.DecimalFormat;
import java.text.ParsePosition;

import static com.javaclasses.calculator.impl.State.NUMBER;

public class NumberParser implements Parser {

    private final State state = NUMBER;
    private ParsePosition parsePosition;

    @Override
    public Double parse(String expression, int pointer){

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        parsePosition = new ParsePosition(0);
        double number;
        try{
            number = decimalFormat.parse(expression.substring(pointer), parsePosition).doubleValue();
            parsePosition.setIndex(parsePosition.getIndex()+ pointer);

        }catch(Exception e){
            return null;
        }


        return number;
    }


    public int getParsePosition(){
        return parsePosition.getIndex();
    }

    @Override
    public State getState(){
        return state;
    }


}