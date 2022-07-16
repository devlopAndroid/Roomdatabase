package com.example.roomdatabase.data.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.data.Room.UserDao


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class Userdatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE: Userdatabase? = null

        fun getDatabase(context: Context): Userdatabase {
            val tempInstance = INSTANCE
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    Userdatabase::class.java,"user_data"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}