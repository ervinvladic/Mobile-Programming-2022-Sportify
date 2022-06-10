package com.example.sportify;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


@Dao
public interface ReservationDao {

    @Insert
    void addReservation(Reservation reservation);

    @Query("SELECT * FROM reservations")
    List<Reservation> getAllReservations();

    @Query("SELECT * FROM reservations WHERE id = :id LIMIT 1")
    Reservation getReservationById(long id);

    @Query("SELECT * FROM reservations JOIN users ON reservations.userId=users.id WHERE users.username=:username")
    List<Reservation> getAllByUsername(String username);


}
