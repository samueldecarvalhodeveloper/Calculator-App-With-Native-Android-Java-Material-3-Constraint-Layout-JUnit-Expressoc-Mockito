package com.example.calculatorapp.unitaries.components;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
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
public class ButtonTest {
    @Test
    public void testIfComponentIsRenderedOnMainActivityAndDispatchesClickEvent() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.addition_button).performClick();
            activity.findViewById(R.id.one_button).performClick();

            TextView viewfinderValueTextView = activity.findViewById(R.id.viewfinder_value_textview);

            String evaluatedCalculationExpressionValue = (String) viewfinderValueTextView.getText();

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, evaluatedCalculationExpressionValue);
        }
    }
}
