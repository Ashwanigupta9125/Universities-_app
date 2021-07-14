package com.example.inter_sporty_guru.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.inter_sporty_guru.collage_data;

@Database(entities =  {collage_data.class} , version = 1 , exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DAO dao();
}