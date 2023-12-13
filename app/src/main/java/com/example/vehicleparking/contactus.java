package com.example.vehicleparking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);

        Button submitButton = findViewById(R.id.button3);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add validation for all details
                if (isContactUsFormValid()) {
                    // Process the form data or navigate to another activity
                    // For now, display a success message
                    showMessage("Details submitted successfully!");
                }
            }
        });
    }

    // Validate all details
    private boolean isContactUsFormValid() {
        // Replace the following lines with the actual references to your EditText fields
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress5);
        EditText messageEditText = findViewById(R.id.editTextTextMultiLine2);

        // Check if any detail is empty
        if (emailEditText.getText().toString().trim().isEmpty() ||
                messageEditText.getText().toString().trim().isEmpty()) {
            showMessage("Please fill in all details");
            return false;
        }
        return true;
    }

    // Display a message
    private void showMessage(String message) {
        // You can display the message in a Toast or any other UI element
        Toast.makeText(contactus.this, message, Toast.LENGTH_SHORT).show();
    }
}
