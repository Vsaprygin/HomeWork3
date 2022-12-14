package com.vsaprygin.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Notes(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var title:String,
    var content:String)
