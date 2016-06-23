package com.javaclasses.calculator.impl.parsers;


import java.text.DecimalFormat;
import java.text.ParsePosition;

public class NumberParser implements Parser {

    private ParsePosition parsePosition;

    @Override
    public Double parse(String expression, int pointer){

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        parsePosition = new ParsePosition(0);
        double number;
        try{
            number = decimalFormat.parse(expression.substring(pointer), parsePosition).doubleValue();

        }catch(Exception e){
            return null;
        }


        return number;
    }

    @Override
    public int getParsePosition(){
        return parsePosition.getIndex();
    }


}