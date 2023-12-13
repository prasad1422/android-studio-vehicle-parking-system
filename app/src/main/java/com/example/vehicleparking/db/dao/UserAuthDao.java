package com.example.vehicleparking.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.vehicleparking.db.model.UserAuthModel;

@Dao
public interface UserAuthDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserAuthModel items);

    @Query("SELECT * from UserAuthModel WHERE `mobile` =:mobile AND `password`=:password")
    UserAuthModel checkLogin(String mobile, String password);
}