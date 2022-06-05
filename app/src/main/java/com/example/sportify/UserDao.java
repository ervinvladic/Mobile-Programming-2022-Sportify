package com.example.sportify;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Insert
    void addUser(Users user);

    @Query("SELECT * FROM users")
    List<Users> getAllUsers();

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    Users getUserById(long id);

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    Users loginUser(String username);

    @Update
    void updateUser(Users user);

    @Delete
    void deleteUser (Users user);

}