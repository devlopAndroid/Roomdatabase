package com.example.roomdatabase.data.Room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_data")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val Name : String,
    val age : Int
)
