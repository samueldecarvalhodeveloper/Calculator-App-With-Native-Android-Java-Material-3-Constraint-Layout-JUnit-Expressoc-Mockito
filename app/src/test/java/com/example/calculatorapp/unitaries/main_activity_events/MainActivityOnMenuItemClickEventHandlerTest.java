package com.example.calculatorapp.unitaries.main_activity_events;

import static org.junit.Assert.assertNotEquals;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class MainActivityOnMenuItemClickEventHandlerTest {
    @Test
    public void testIfMethodOnMenuItemClickDispatchesActionBarToggleNightModeAction() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            int initialApplicationThemeMode = AppCompatDelegate.getDefaultNightMode();

            activity.findViewById(R.id.toggle_night_mode_menu_item).performClick();

            int currentUserInterfaceMode = AppCompatDelegate.getDefaultNightMode();

            assertNotEquals(initialApplicationThemeMode, currentUserInterfaceMode);
        }
    }
}
