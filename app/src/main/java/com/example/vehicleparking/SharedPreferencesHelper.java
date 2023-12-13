package com.example.vehicleparking;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Kalmeshwar on 07 Dec 2023 at 23:35.
 */
class SharedPreferencesHelper {
    private static final String PREF_NAME = "MyPreferences";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";

    // Save data to SharedPreferences
    public static void saveData(Context context, String username, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASS, password);
        editor.apply();
    }

    // Fetch data from SharedPreferences
    public static String getUsername(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    public static String getPassword(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PASS, "");
    }
}
