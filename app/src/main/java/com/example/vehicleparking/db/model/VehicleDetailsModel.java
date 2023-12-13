package com.example.vehicleparking.db.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kalmeshwar on 09 Dec 2023 at 11:44.
 */
@Entity
public class VehicleDetailsModel {
    @NonNull
    @SerializedName("owner_name")
    private String owner_name;

    @NonNull
    @SerializedName("mobile_number")
    private String mobile_number;

    @NonNull
    @SerializedName("time")
    private String time;

    @NonNull
    @PrimaryKey
    @SerializedName("vehicle_no")
    private String vehicle_no;

    @NonNull
    @SerializedName("vehicle_name")
    private String vehicle_name;

    @NonNull
    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(@NonNull String owner_name) {
        this.owner_name = owner_name;
    }

    @NonNull
    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(@NonNull String mobile_number) {
        this.mobile_number = mobile_number;
    }

    @NonNull
    public String getTime() {
        return time;
    }

    public void setTime(@NonNull String time) {
        this.time = time;
    }

    @NonNull
    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(@NonNull String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    @NonNull
    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(@NonNull String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }
}