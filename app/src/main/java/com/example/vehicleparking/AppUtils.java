package com.example.vehicleparking;

import android.widget.Toast;

import com.example.vehicleparking.application.ApplicationDetails;

public final class AppUtils {

    private AppUtils() {
        // This class is not publicly instantiable
    }

    public static void showToast(String message) {
        try {
            Toast.makeText(ApplicationDetails.getInstance(), message, Toast.LENGTH_LONG).show();
        } catch (Throwable ignored) {
        }
    }
}