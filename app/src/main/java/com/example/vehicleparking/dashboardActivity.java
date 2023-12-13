package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class dashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        Button editProfileButton = findViewById(R.id.button18);
        Button slotBookingButton = findViewById(R.id.button19);
        Button userProfileButton = findViewById(R.id.button20);
        Button feedbackButton = findViewById(R.id.button21);
        Button vehicleCountButton = findViewById(R.id.button16);
        Button changePasswordButton = findViewById(R.id.button25);
        Button registerDetailsButton = findViewById(R.id.button27);
        Button aboutusButton = findViewById(R.id.button9);

        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dashboardActivity.this, editprofileactivity.class);
                startActivity(intent);
            }
        });

        slotBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dashboardActivity.this, SlotBookingActivity.class);
                startActivity(intent);
            }
        });

        userProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dashboardActivity.this, editprofileactivity.class);
                startActivity(intent);
            }
        });

        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dashboardActivity.this, feedbackActivity.class);
                startActivity(intent);
            }
        });

        vehicleCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dashboardActivity.this, registervehicleActivity.class);
                startActivity(intent);
            }
        });

        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboardActivity.this, ChangePasswordActivity.class);
                startActivity(intent);

            }
        });

        registerDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dashboardActivity.this, registervehicleActivity.class);
                startActivity(intent);
            }
        });

        aboutusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(dashboardActivity.this, about_us.class);
                startActivity(intent);
            }
        });

        Button LogoutButton = findViewById(R.id.button12);

        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboardActivity.this, signupActivity.class);
                startActivity(intent);
            }
        });
    }
}
