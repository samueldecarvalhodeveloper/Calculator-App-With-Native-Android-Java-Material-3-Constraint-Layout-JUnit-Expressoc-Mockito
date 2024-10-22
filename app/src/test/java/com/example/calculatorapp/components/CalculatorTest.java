package com.example.calculatorapp.components;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;

import com.example.calculatorapp.domains.calculator.CalculationExpression;
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecord;
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator;
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister;
import com.example.calculatorapp.domains.calculator.Calculator;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void beforeAll() {
        CalculationExpression calculationExpression = new CalculationExpression("");
        CalculationExpressionRegister calculationExpressionRegister = new CalculationExpressionRegister(calculationExpression);
        CalculationExpressionActiveRecord calculationExpressionActiveRecord = new CalculationExpressionActiveRecordDecorator(calculationExpressionRegister);
        calculator = new Calculator(calculationExpressionActiveRecord);
    }

    @Test
    public void testIfComponentHandlesDataInputAndOutputsScenario() {
        String initialCalculationExpression = calculator.getCalculationExpression();

        assertEquals("", initialCalculationExpression);

        calculator.addCharacter(CalculatorCharacters.ONE);
        calculator.addCharacter(CalculatorCharacters.ADDITION);
        calculator.addCharacter(CalculatorCharacters.ONE);

        calculator.backspace();

        calculator.addCharacter(CalculatorCharacters.ONE);

        calculator.evaluate();

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression);

        calculator.clean();

        String finalCalculationExpression = calculator.getCalculationExpression();

        assertEquals("", finalCalculationExpression);
    }
}
