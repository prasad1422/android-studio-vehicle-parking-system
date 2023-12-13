package com.example.vehicleparking.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.vehicleparking.db.dao.UserAuthDao;
import com.example.vehicleparking.db.dao.VehicleDetailsDao;
import com.example.vehicleparking.db.model.UserAuthModel;
import com.example.vehicleparking.db.model.VehicleDetailsModel;

@Database(entities = {UserAuthModel.class, VehicleDetailsModel.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserAuthDao userAuthDao();

    public abstract VehicleDetailsDao vehicleDao();

}