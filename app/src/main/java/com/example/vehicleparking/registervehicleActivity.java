package com.example.vehicleparking;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vehicleparking.db.AppDbHelper;
import com.example.vehicleparking.db.model.VehicleDetailsModel;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class registervehicleActivity extends AppCompatActivity {

    private EditText user1EditText;
    private EditText user2EditText;
    private EditText user3EditText;
    private EditText user4EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_register_details);

        user1EditText = findViewById(R.id.editTextText4);
        user2EditText = findViewById(R.id.editTextText5);
        user3EditText = findViewById(R.id.editTextText6);
        user4EditText = findViewById(R.id.editTextText7);

        Single.create((SingleOnSubscribe<List<VehicleDetailsModel>>) emitter -> {
                    List<VehicleDetailsModel> vehicleList = AppDbHelper.getInstance().getVehicleList();
                    emitter.onSuccess(vehicleList);
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(new SingleObserver<List<VehicleDetailsModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<VehicleDetailsModel> vehicleList) {
                        if (vehicleList != null && vehicleList.size() > 0) {
                            VehicleDetailsModel model = vehicleList.get(0);
                            if (model != null) {
                                String info = "Vehicle Number: " + model.getVehicle_no() + "\n "
                                        + "Vehicle Name: " + model.getVehicle_name() + "\n "
                                        + "Time: " + model.getTime() + "\n "
                                        + "Mobile Number: " + model.getMobile_number();
                                user1EditText.setText(info);
                            }

                            if (vehicleList.size() > 1) {
                                model = vehicleList.get(1);
                                if (model != null) {
                                    String info = "Vehicle Number: " + model.getVehicle_no() + "\n "
                                            + "Vehicle Name: " + model.getVehicle_name() + "\n "
                                            + "Time: " + model.getTime() + "\n "
                                            + "Mobile Number: " + model.getMobile_number();
                                    user2EditText.setText(info);
                                }
                            }

                            if (vehicleList.size() > 2) {
                                model = vehicleList.get(2);
                                if (model != null) {
                                    String info = "Vehicle Number: " + model.getVehicle_no() + "\n "
                                            + "Vehicle Name: " + model.getVehicle_name() + "\n "
                                            + "Time: " + model.getTime() + "\n "
                                            + "Mobile Number: " + model.getMobile_number();
                                    user3EditText.setText(info);
                                }
                            }

                            if (vehicleList.size() > 2) {
                                model = vehicleList.get(3);
                                if (model != null) {
                                    String info = "Vehicle Number: " + model.getVehicle_no() + "\n "
                                            + "Vehicle Name: " + model.getVehicle_name() + "\n "
                                            + "Time: " + model.getTime() + "\n "
                                            + "Mobile Number: " + model.getMobile_number();
                                    user4EditText.setText(info);
                                }
                            }
                        } else {
                            AppUtils.showToast("Slot booking not found");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });

    }
}
