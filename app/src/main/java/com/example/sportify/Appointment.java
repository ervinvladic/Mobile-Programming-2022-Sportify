package com.example.sportify;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "appointment")
public class Appointment {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo (name="courtId")
    long courtId;
    @ColumnInfo (name="userId")
    long userId;
    @ColumnInfo (name="date")
    Date date;
    @ColumnInfo (name="time")
    String time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourtId() {
        return courtId;
    }

    public void setCourtId(long courtId) {
        this.courtId = courtId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long UserId) {
        this.userId= userId;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}