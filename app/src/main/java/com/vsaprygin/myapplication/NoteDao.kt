package com.vsaprygin.myapplication



import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query



@Dao
interface NoteDao {
    @Query("Select * from Notes")
    fun getAll(): List<Notes>

    @Insert(onConflict = REPLACE)
    fun insert(notesRepository: Notes)

    @Delete
    fun delete(post: Notes)
}