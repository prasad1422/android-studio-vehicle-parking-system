package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SlotBookingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slot_booking);


        Button slot1Button = findViewById(R.id.buttonSlot1);
        Button slot2Button = findViewById(R.id.buttonSlot2);
        Button slot3Button = findViewById(R.id.buttonSlot3);
        Button slot4Button = findViewById(R.id.buttonSlot4);
        Button userProfileButton = findViewById(R.id.buttonUserProfile);


        slot1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SlotBookingActivity.this, vehicleDetails.class);
                startActivity(intent);
            }
        });

        slot2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SlotBookingActivity.this, vehicleDetails.class);
                startActivity(intent);
            }
        });

        slot3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SlotBookingActivity.this, vehicleDetails.class);
                startActivity(intent);
            }
        });

        slot4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SlotBookingActivity.this, vehicleDetails.class);
                startActivity(intent);
            }
        });

        userProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent userProfileIntent = new Intent(SlotBookingActivity.this, editprofileactivity.class);
                startActivity(userProfileIntent);
            }
        });

    }
}