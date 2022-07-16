package com.example.roomdatabase.data.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.Room.User
import com.example.roomdatabase.data.Room.UserRepository
import com.example.roomdatabase.data.Room.Userdatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class Userviewmodel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<User>>
    private val repository : UserRepository

    init {
        val userDao = Userdatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAlldata
    }

    fun addUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }

}