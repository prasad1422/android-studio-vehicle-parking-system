package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class userProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityuserprofile);


        Button editButton = findViewById(R.id.button15);


        editButton.setOnClickListener(v -> {

            Intent intent = new Intent(userProfile.this, editprofileactivity.class);
            startActivity(intent);
        });
    }
}
