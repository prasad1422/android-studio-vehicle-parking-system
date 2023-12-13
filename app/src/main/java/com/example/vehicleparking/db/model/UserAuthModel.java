package com.example.vehicleparking.db.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kalmeshwar on 18 Nov 2023 at 15:19.
 */
@Entity
public class UserAuthModel {
    @NonNull
    @SerializedName("name")
    private String name;
    @NonNull
    @SerializedName("emailAddress")
    private String emailAddress;

    @NonNull
    @PrimaryKey
    @SerializedName("mobile")
    private String mobile;

    @NonNull
    @SerializedName("password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    public String getMobile() {
        return mobile;
    }

    public void setMobile(@NonNull String mobile) {
        this.mobile = mobile;
    }
}
