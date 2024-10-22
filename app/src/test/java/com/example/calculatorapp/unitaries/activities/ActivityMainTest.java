package com.example.calculatorapp.unitaries.activities;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isUserInterfaceInNightMode;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class ActivityMainTest {
    private final Context curretActivityContext = InstrumentationRegistry.getInstrumentation()
            .getTargetContext();

    @Test
    public void testIfInitialThemeIsRetrievedFromThemeStoreAndConfiguredOnTheUserInterface() {
        boolean storedUiMode = UserInterfaceThemeStore.getNightModeThemeState(curretActivityContext);
        boolean currentUiMode = isUserInterfaceInNightMode();

        assertEquals(currentUiMode, storedUiMode);
    }

    @Test
    public void testIfMenuItemClickMethodOnViewModelDispatchesTheToggleModeItemAndChangeApplicationMode() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.toggle_night_mode_menu_item).performClick();

            int currentUserInterfaceMode = AppCompatDelegate.getDefaultNightMode();

            assertEquals(AppCompatDelegate.MODE_NIGHT_YES, currentUserInterfaceMode);

            activity.findViewById(R.id.toggle_night_mode_menu_item).performClick();
        }
    }

    @Test
    public void testIfViewfinderIsObservingCalculatorViewmodelCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.addition_button).performClick();
            activity.findViewById(R.id.one_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentViewfinderValue);
        }
    }

    @Test
    public void testIfCleanButtonWhenClickedDispatchesClearCalculationExpressionMethodOnViewModel() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.clean_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            assertEquals("", currentViewfinderValue);
        }
    }

    @Test
    public void testIfDivisionButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheDivisionCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.division_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.DIVISION.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfMultiplicationButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheMultiplicationCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.multiplication_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.MULTIPLICATION.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfBackspaceBackspaceWhenClickedDispatchesBackspaceMethodOnViewModelAndRemovesLastCharacterFromCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.backspace_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.ONE.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfSevenButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheSevenCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.seven_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.SEVEN.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfEightButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheEightCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.eight_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.EIGHT.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfNineButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheNineCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.nine_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.NINE.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfSubtractionButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheSubtractionCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.subtraction_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.SUBTRACTION.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfFourButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheFourCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.four_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.FOUR.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfFiveButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheFiveCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.five_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.FIVE.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfSixButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheSixCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.six_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.SIX.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfAdditionButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheAdditionCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.addition_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.ADDITION.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfOneButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheOneCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.ONE.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfTwoButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheTwoCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.two_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.TWO.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfThreeButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheThreeCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.three_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.THREE.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfZeroButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheZeroCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.zero_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.ZERO.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfPointButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsThePointCharacterToCalculationExpression() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.point_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String characterOfClickedButton = CalculatorCharacters.POINT.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        }
    }

    @Test
    public void testIfEvaluationButtonWhenClickedDispatchesEvaluateMethodOnViewModelAndEvaluatesCalculationExpression() {
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
