package com.example.vehicleparking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class adminsignupActivity extends AppCompatActivity {

    private Button signupButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_signup);
        init();

        signupButton = findViewById(R.id.button11);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(adminsignupActivity.this, registervehicleActivity.class);
                startActivity(loginIntent);
            }
        });
    }

    private void init() {

    }
}

