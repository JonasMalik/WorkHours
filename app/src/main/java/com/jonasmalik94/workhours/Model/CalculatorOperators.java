package com.jonasmalik94.workhours.Model;

/**
 * Created by jonas on 2016-10-16.
 */

public class CalculatorOperators {
    int result;
    String sResult;

    public String operation(String firstValue, String secondValue, String operator){
        int convertedValue1 = Integer.parseInt(firstValue);
        int convertedValue2 = Integer.parseInt(secondValue);

        if (operator.equals("+")){
            sResult = Integer.toString(addition(convertedValue1,convertedValue2));
        }
        if (operator.equals("-")) {
            sResult = Integer.toString(subtraction(convertedValue1,convertedValue2));
        }
        if (operator.equals("/")) {
            sResult = Integer.toString(division(convertedValue1,convertedValue2));
        }
        if (operator.equals("*")) {
            sResult = Integer.toString(multiplication(convertedValue1,convertedValue2));
        }

        return sResult;
    }

    public int subtraction(int firstValue, int secondValue){
        result = firstValue-secondValue;
        return result;
    }

    public int addition(int firstValue, int secondValue){
        result = firstValue+secondValue;
        return result;
    }

    public int division(int firstValue, int secondValue){
        result = firstValue/secondValue;
        return result;
    }

    public int multiplication(int firstValue, int secondValue){
        result = firstValue*secondValue;
        return result;
    }

}
