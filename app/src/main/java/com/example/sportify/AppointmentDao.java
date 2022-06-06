package com.example.sportify;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AppointmentDao {

    @Insert
    void addAppointment(Appointment appointment);

    @Query("SELECT * FROM appointment")
    List<Appointment> getAllAppointments();

    @Query("SELECT * FROM appointment WHERE id = :id LIMIT 1")
    Appointment getAppointmentById(long id);

    @Query("SELECT * FROM appointment JOIN users ON appointment.userId=users.id WHERE users.username=:username")
    List<Appointment> getAllByUsername(String username);


    @Update
    void updateAppointment(Appointment appointment);

    @Delete
    void deleteAppointment (Appointment appointment);

}