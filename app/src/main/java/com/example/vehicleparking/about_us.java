package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class about_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        Button giveFeedbackButton = findViewById(R.id.button4);

        giveFeedbackButton.setOnClickListener(v -> {

            Intent intent = new Intent(about_us.this, feedbackActivity.class);
            startActivity(intent);
        });
    }
}
