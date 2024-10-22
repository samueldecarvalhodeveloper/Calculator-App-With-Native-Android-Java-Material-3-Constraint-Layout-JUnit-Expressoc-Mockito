package com.example.calculatorapp.unitaries.components;

import static com.example.calculatorapp.constants.UserInterfaceConstants.VIEWFINDER_SCROLL_TO_END_VALUE;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;

import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.test.filters.LargeTest;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

@RunWith(RobolectricTestRunner.class)
@LargeTest
public class ViewfinderTest {
    @Test
    public void testIfComponentIsRenderedOnMainActivity() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            TextView viewfinderValueTextView = activity.findViewById(R.id.viewfinder_value_textview);

            String evaluatedCalculationExpressionValue = (String) viewfinderValueTextView.getText();

            assertEquals("", evaluatedCalculationExpressionValue);
        }
    }

    @Test
    public void testIfMethodSetViewfinderValueUpdatesViewfinderValueTextviewText() {
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

    @Test
    public void testIfMethodScrollToTheEndScrollsViewfinderValueHorizontalScrollViewToTheEnd() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();

            HorizontalScrollView viewfinderValueHorizontalScrollView = activity.findViewById(R.id.viewfinder_value_scrollview);
            TextView viewfinderValueTextView = activity.findViewById(R.id.viewfinder_value_textview);

            int viewfinderValueHorizontalScrollviewScrollX = viewfinderValueHorizontalScrollView.getScrollX();
            int viewfinderValueTextViewWidth = viewfinderValueTextView.getWidth();

            assertEquals(
                    VIEWFINDER_SCROLL_TO_END_VALUE(viewfinderValueTextViewWidth),
                    viewfinderValueHorizontalScrollviewScrollX
            );
        }
    }
}
