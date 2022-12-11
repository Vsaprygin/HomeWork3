package com.vsaprygin.myapplication

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Notes::class], version=1)
abstract class LocalDB:RoomDatabase() {
    abstract fun noteDao(): NoteDao
}