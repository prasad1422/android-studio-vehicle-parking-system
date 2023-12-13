package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vehicleparking.db.AppDbHelper;
import com.example.vehicleparking.db.model.UserAuthModel;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class editprofileactivity extends AppCompatActivity {
    private TextView textViewTitle;
    private ImageView imageView12;
    private Button saveChangesButton;
    private ImageView imageView13;
    private EditText emailEditText;
    private EditText phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        textViewTitle = findViewById(R.id.textViewTitle);
        imageView12 = findViewById(R.id.imageView12);
        saveChangesButton = findViewById(R.id.button26);
        emailEditText = findViewById(R.id.editTextTextEmailAddress4);
        phoneEditText = findViewById(R.id.editTextPhone4);

        String mobileNumber = SharedPreferencesHelper.getUsername(this);
        String password = SharedPreferencesHelper.getPassword(this);

        Single.create((SingleOnSubscribe<UserAuthModel>) emitter -> {
                    UserAuthModel model = AppDbHelper.getInstance().getUserData(mobileNumber, password);
                    if (model != null) {
                        emitter.onSuccess(model);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(new SingleObserver<UserAuthModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(UserAuthModel userModel) {
                        emailEditText.setText(userModel.getEmailAddress());
                        phoneEditText.setText(userModel.getMobile());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges();

                Intent intent = new Intent(editprofileactivity.this, dashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void saveChanges() {

    }
}
