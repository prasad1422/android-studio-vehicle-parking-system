package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class feedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_submit_page);


        Button feedbackButton = findViewById(R.id.button22);


        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(feedbackActivity.this, dashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
