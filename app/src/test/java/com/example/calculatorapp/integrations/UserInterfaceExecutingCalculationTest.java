package com.example.calculatorapp.integrations;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;

import android.widget.TextView;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class UserInterfaceExecutingCalculationTest {
    @Test
    public void testIfCalculationExpressionIsExecutedOnUserInterface() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.addition_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.evaluation_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentViewfinderValue);
        }
    }
}
