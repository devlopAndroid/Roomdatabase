package com.example.roomdatabase.data.Room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.roomdatabase.data.Room.User
import com.example.roomdatabase.data.Room.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val readAlldata : LiveData<List<User>> = userDao.readAllData()


    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}