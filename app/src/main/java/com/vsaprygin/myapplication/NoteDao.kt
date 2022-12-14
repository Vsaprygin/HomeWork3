package com.vsaprygin.myapplication
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("Select * from Notes")
    fun getAll(): LiveData<List<Notes>>

    @Insert(onConflict = REPLACE)
    fun insert(notes: Notes)

    @Delete
    fun delete(notes: Notes)
}