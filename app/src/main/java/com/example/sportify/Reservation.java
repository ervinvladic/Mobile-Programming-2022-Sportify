package com.example.sportify;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "reservations", foreignKeys = @ForeignKey(entity = Users.class, parentColumns = "id", childColumns = "userId"))
public class Reservation {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long userId;
    private String courtName;
    private String date;
    private String time;

    public Reservation(long userId, String courtName, String date, String time) {
        this.userId = userId;
        this.courtName = courtName;
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
