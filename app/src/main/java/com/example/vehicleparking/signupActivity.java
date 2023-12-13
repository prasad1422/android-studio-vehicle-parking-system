package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vehicleparking.db.AppDbHelper;
import com.example.vehicleparking.db.model.UserAuthModel;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class signupActivity extends AppCompatActivity {

    private Button loginButton;
    private Button saveButton;
    private EditText phoneNumberEditText;
    private EditText emailAddressEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        init();

        saveButton = findViewById(R.id.button5);
        phoneNumberEditText = findViewById(R.id.editTextPhone);
        emailAddressEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        confirmPasswordEditText = findViewById(R.id.editTextTextPassword2);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                String emailAddress = emailAddressEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                if (phoneNumber.length() != 10) {
                    Toast.makeText(signupActivity.this, "Phone number must be 10 digits.", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(emailAddress)) {
                    Toast.makeText(signupActivity.this, "Invalid email address. Use the @gmail.com format.", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(signupActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                } else {
                    UserAuthModel authModel = new UserAuthModel();
                    authModel.setName("Prasad");
                    authModel.setEmailAddress(emailAddress);
                    authModel.setMobile(phoneNumber);
                    authModel.setPassword(password);

                    AppDbHelper.getInstance().adduserData(authModel);

                    Intent loginIntent = new Intent(signupActivity.this, LoginActivity.class);
                    startActivity(loginIntent);

                    // Create a user with email and password
//                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailAddress, password)
//                            .addOnCompleteListener(signupActivity.this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
//                                        // Sign in success
//                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                                        // Save additional user data to Realtime Database if needed
//
//                                        // Move to the next activity
//                                        Intent loginIntent = new Intent(signupActivity.this, LoginActivity.class);
//                                        startActivity(loginIntent);
//                                    } else {
//                                        // If sign in fails, display a message to the user.
//                                        Toast.makeText(signupActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            });
                }
            }
        });

        loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(signupActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }

    private void init() {

    }

    private boolean isValidEmail(String email) {
        String emailPattern = ".*@gmail.com";
        return email.matches(emailPattern);
    }
}
