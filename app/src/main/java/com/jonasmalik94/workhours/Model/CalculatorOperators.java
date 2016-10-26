package com.jonasmalik94.workhours.Model;

/**
 * Created by jonas on 2016-10-16.
 */

public class CalculatorOperators {
    double result;
    String sResult;

    public String operation(String firstValue, String secondValue, String operator){
        double convertedValue1 = Double.parseDouble(firstValue);
        double convertedValue2 = Double.parseDouble(secondValue);

        if (operator.equals("+")){
            sResult = Double.toString(addition(convertedValue1,convertedValue2));
        }
        if (operator.equals("-")) {
            sResult = Double.toString(subtraction(convertedValue1,convertedValue2));
        }
        if (operator.equals("/")) {
            sResult = Double.toString(division(convertedValue1,convertedValue2));
        }
        if (operator.equals("*")) {
            sResult = Double.toString(multiplication(convertedValue1,convertedValue2));
        }

        return sResult;
    }

    public double subtraction(double firstValue, double secondValue){
        result = firstValue-secondValue;
        return result;
    }

    public double addition(double firstValue, double secondValue){
        result = firstValue+secondValue;
        return result;
    }

    public double division(double firstValue, double secondValue){
        result = firstValue/secondValue;
        return result;
    }

    public double multiplication(double firstValue, double secondValue){
        result = firstValue*secondValue;
        return result;
    }

}
