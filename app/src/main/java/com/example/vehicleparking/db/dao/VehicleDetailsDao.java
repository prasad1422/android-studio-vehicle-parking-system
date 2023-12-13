package com.example.vehicleparking.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.vehicleparking.db.model.VehicleDetailsModel;

import java.util.List;

@Dao
public interface VehicleDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVehicleData(VehicleDetailsModel item);

    @Query("SELECT * from VehicleDetailsModel")
    List<VehicleDetailsModel> getVehicleList();
}