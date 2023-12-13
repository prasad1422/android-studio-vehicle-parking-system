package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Confirmation extends AppCompatActivity {

    private EditText nameEditText;
    private EditText phoneEditText;
    private EditText dateEditText;
    private EditText timeEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_details);


        nameEditText = findViewById(R.id.editTextText3);
        phoneEditText = findViewById(R.id.editTextPhone8);
        dateEditText = findViewById(R.id.editTextDate);
        timeEditText = findViewById(R.id.editTextTime2);
        submitButton = findViewById(R.id.button8);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String date = dateEditText.getText().toString();
                String time = timeEditText.getText().toString();


                if (name.isEmpty() || phone.isEmpty() || date.isEmpty() || time.isEmpty()) {

                    Toast.makeText(Confirmation.this, "Please fill manually in all fields if details wrong and check details ones sbmit button clicked u can't change ", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(Confirmation.this, dashboardActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
