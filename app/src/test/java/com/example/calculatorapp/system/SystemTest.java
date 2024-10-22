package com.example.calculatorapp.system;

import static com.example.calculatorapp.constants.ApplicationConstants.APPLICATION_SHARED_PREFERENCES_NAME;
import static com.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY;
import static com.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

import java.util.HashMap;
import java.util.Map;

@RunWith(RobolectricTestRunner.class)
public class SystemTest {
    public static Context context;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;
    public static Map mapWithStoredCalculationExpression;

    @BeforeClass
    public static void beforeAll() {
        context = mock(Context.class);
        sharedPreferences = mock(SharedPreferences.class);
        sharedPreferencesEditor = mock(SharedPreferences.Editor.class);

        mapWithStoredCalculationExpression = new HashMap<String, Object>();

        mapWithStoredCalculationExpression.put(LAST_SESSION_CALCULATION_EXPRESSION_KEY, EVALUATED_SIMPLE_CALCULATION_EXPRESSION);
        mapWithStoredCalculationExpression.put(THEME_KEY, true);

        when(context.getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)).thenReturn(sharedPreferences);

        when(sharedPreferences.getAll()).thenReturn(mapWithStoredCalculationExpression);
    }

    @Test
    public void testIfCalculationIsExecutedAndStoredInKeyValueDatabaseOnUserInterface() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.addition_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.evaluation_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String storedCalculationExpression = (String) mapWithStoredCalculationExpression.get(LAST_SESSION_CALCULATION_EXPRESSION_KEY);

            assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentViewfinderValue);
            assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, storedCalculationExpression);
        }
    }

    @Test
    public void testIfToggleThemeIsExecutedOnAndStoredInKeyValueDatabaseOnUserInterface() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.toggle_night_mode_menu_item).performClick();

            boolean currentUserInterfaceMode = UserInterfaceThemeStore.getNightModeThemeState(context);

            assertTrue(currentUserInterfaceMode);
        }
    }
}
