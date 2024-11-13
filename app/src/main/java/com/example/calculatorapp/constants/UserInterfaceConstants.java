package com.example.calculatorapp.constants;

public class UserInterfaceConstants {
    public static final String LAST_SESSION_CALCULATION_EXPRESSION_KEY = "calculationexpression";

    public static final String THEME_KEY = "theme";

    private UserInterfaceConstants() {
    }

    public static String NOT_EXISTING_KEY_EXCEPTION_MESSAGE(String key) {
        return "Key: \"" + key + "\"; Does Not Exist!";
    }

    public static int VIEWFINDER_SCROLL_TO_END_VALUE(int viewfinderScrollViewWidth) {
        return viewfinderScrollViewWidth * 1000000;
    }
}
