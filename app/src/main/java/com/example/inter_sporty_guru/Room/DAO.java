package com.example.inter_sporty_guru.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.inter_sporty_guru.collage_data;

import java.util.List;

@Dao
public interface DAO {


    @Insert
    public void DataInsertion(collage_data Datainsert);

   @Query("SELECT * FROM collage_data ORDER BY coll_name LIMIT 1")
    LiveData<collage_data> loadlastTask();


    @Query("Select * from collage_data")
    List<collage_data> get_coll_data();

}
