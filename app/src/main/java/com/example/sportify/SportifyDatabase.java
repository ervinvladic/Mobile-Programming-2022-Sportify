package com.example.sportify;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Users.class},version = 1,exportSchema = false)
public abstract class SportifyDatabase extends RoomDatabase {
    public abstract SportifyDao sportifyDao();
    private static SportifyDatabase INSTANCE;

    public static SportifyDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,SportifyDatabase.class,"app_database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}