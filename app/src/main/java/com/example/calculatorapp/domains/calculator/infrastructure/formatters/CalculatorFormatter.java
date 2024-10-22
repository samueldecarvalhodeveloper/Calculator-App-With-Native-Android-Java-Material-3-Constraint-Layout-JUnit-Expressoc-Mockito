package com.example.calculatorapp.domains.calculator.infrastructure.formatters;

public class CalculatorFormatter {
    private CalculatorFormatter() {
    }

    public static String getCalculationExpressionWithoutLastCharacter(String calculationExpression) {
        return calculationExpression.substring(0, calculationExpression.length() - 1);
    }
}
