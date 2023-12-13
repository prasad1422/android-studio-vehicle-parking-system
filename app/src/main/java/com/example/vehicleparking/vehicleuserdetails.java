package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vehicleparking.db.AppDbHelper;
import com.example.vehicleparking.db.model.VehicleDetailsModel;

public class vehicleuserdetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_details_users);

        Button saveandpayButton = findViewById(R.id.button34);
        EditText vehicleName = findViewById(R.id.editTextText);
        EditText vehicleNumber = findViewById(R.id.editTextNumber);
        EditText ownerNumber = findViewById(R.id.editTextPhone5);
        EditText slotTime = findViewById(R.id.editTextTime);

        saveandpayButton.setOnClickListener(v -> {
            VehicleDetailsModel model = new VehicleDetailsModel();
            model.setMobile_number(ownerNumber.getText().toString().trim());
            model.setTime(slotTime.getText().toString().trim());
            model.setVehicle_name(vehicleName.getText().toString().trim());
            model.setVehicle_no(vehicleNumber.getText().toString().trim());
            model.setOwner_name("Owner Name");

            AppDbHelper.getInstance().addVehicleData(model);
            AppUtils.showToast("Slot booked Successfully");
            Intent intent = new Intent(vehicleuserdetails.this, dashboardActivity.class);
            startActivity(intent);
            finishAffinity();
        });
    }
}
