package com.example.sportify;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SportifyDao {

    @Insert
    void add(Users user);

    @Query("SELECT * FROM users")
    List<Users> getAllUsers();

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    Users getUserById(long id);

    @Update
    void updateUser(Users user);

    @Delete
    void deleteUser (Users user);

}