package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText oldPasswordEditText;
    private EditText newPasswordEditText;
    private EditText confirmNewPasswordEditText;
    private Button savePasswordButton;
    private Button backToLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_reset);

        oldPasswordEditText = findViewById(R.id.editTextTextPassword5);
        newPasswordEditText = findViewById(R.id.editTextTextPassword6);
        confirmNewPasswordEditText = findViewById(R.id.editTextTextPassword7);
        savePasswordButton = findViewById(R.id.button17);
        backToLoginButton = findViewById(R.id.button23);

        savePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPassword = oldPasswordEditText.getText().toString();
                String newPassword = newPasswordEditText.getText().toString();
                String confirmNewPassword = confirmNewPasswordEditText.getText().toString();

                if (newPassword.equals(confirmNewPassword)) {

                } else {

                    Toast.makeText(ChangePasswordActivity.this, "New password and confirm password do not match.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
