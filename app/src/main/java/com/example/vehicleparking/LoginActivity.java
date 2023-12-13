package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vehicleparking.db.AppDbHelper;
import com.example.vehicleparking.db.model.UserAuthModel;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private Button signupButton;
    private EditText phoneNumberEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.button6);
        signupButton = findViewById(R.id.button7);
        phoneNumberEditText = findViewById(R.id.editTextPhone2);
        passwordEditText = findViewById(R.id.editTextTextPassword3);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, signupActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (phoneNumber.length() == 10) {
                    if (password.length() >= 6) { // Check if password is at least 6 characters long

                        Single.create((SingleOnSubscribe<Boolean>) emitter -> {
                                    UserAuthModel model = AppDbHelper.getInstance().getUserData(phoneNumber, password);

                                    if (model != null) {
                                        emitter.onSuccess(true);
                                    } else {
                                        emitter.onSuccess(false);
                                    }
                                }).subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()).
                                subscribe(new SingleObserver<Boolean>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {
                                    }

                                    @Override
                                    public void onSuccess(Boolean isLoginSuccessful) {
                                        if (isLoginSuccessful) {
                                            SharedPreferencesHelper.saveData(LoginActivity.this, phoneNumber, password);

                                            Intent intent = new Intent(LoginActivity.this, dashboardActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(LoginActivity.this, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                    }
                                });
                    } else {
                        Toast.makeText(LoginActivity.this, "Password should be at least 6 characters long.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Please enter a 10-digit phone number.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean authenticateUser(String phoneNumber, String password) {

        String validPhoneNumber = "1234567890";
        String validPassword = "password123";

        return phoneNumber.equals(validPhoneNumber) && password.equals(validPassword);
    }
}
