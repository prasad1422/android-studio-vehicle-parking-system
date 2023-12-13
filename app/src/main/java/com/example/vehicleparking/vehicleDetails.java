package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class vehicleDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);

        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress6);

        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    emailEditText.setHint("");
                } else {
                    if (emailEditText.getText().length() == 0) {
                        emailEditText.setHint("Email Address");
                    }
                }
            }
        });

        Button submitButton = findViewById(R.id.button24);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add validation for all fields
                if (isFormValid()) {
                    Intent intent = new Intent(vehicleDetails.this, vehicleuserdetails.class);
                    startActivity(intent);
                }
            }
        });
    }

    // Validate all fields
    private boolean isFormValid() {
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress6);
        // Add more EditText references for other fields

        // Check if any field is empty
        if (emailEditText.getText().toString().trim().isEmpty()) {
            showMessage("Please fill in all fields");
            return false;
        }
        // Add similar checks for other fields

        return true;
    }

    // Display a message
    private void showMessage(String message) {
        // You can display the message in a Toast or any other UI element
        Toast.makeText(vehicleDetails.this, message, Toast.LENGTH_SHORT).show();
    }
}
