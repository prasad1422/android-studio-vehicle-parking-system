package com.example.vehicleparking.db;

import androidx.room.Room;

import com.example.vehicleparking.AppUtils;
import com.example.vehicleparking.application.ApplicationDetails;
import com.example.vehicleparking.db.model.UserAuthModel;
import com.example.vehicleparking.db.model.VehicleDetailsModel;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AppDbHelper {
    private AppDatabase mAppDatabase;
    private static AppDbHelper appDbHelper;

    private AppDbHelper() {
        try {
            this.mAppDatabase = Room.databaseBuilder(ApplicationDetails.getInstance().getContext(), AppDatabase.class, DBConstants.DB_NAME).build();
        } catch (Throwable throwable) {
            AppUtils.showToast(throwable.getMessage());
        }
    }

    public static AppDbHelper getInstance() {
        if (appDbHelper == null) {
            appDbHelper = new AppDbHelper();
        }
        return appDbHelper;
    }

    public void adduserData(UserAuthModel item) {
        try {
            Single.create((SingleOnSubscribe<String>) emitter -> {
                        mAppDatabase.userAuthDao().insertUser(item);
                        emitter.onSuccess("completed");
                    }).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).
                    subscribe(new SingleObserver<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onSuccess(String status) {

                        }

                        @Override
                        public void onError(Throwable e) {
                        }
                    });
        } catch (Throwable ignore) {
            ignore.printStackTrace();
        }
    }

    public UserAuthModel getUserData(String mobile, String password) {
        return mAppDatabase.userAuthDao().checkLogin(mobile, password);
    }

    public void addVehicleData(VehicleDetailsModel item) {
        try {
            Single.create((SingleOnSubscribe<String>) emitter -> {
                        mAppDatabase.vehicleDao().insertVehicleData(item);
                        emitter.onSuccess("completed");
                    }).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).
                    subscribe(new SingleObserver<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onSuccess(String status) {

                        }

                        @Override
                        public void onError(Throwable e) {
                        }
                    });
        } catch (Throwable ignore) {
            ignore.printStackTrace();
        }
    }

    public List<VehicleDetailsModel> getVehicleList() {
        return mAppDatabase.vehicleDao().getVehicleList();
    }
}