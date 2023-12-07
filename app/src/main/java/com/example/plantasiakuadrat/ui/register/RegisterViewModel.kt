package com.example.plantasiakuadrat.ui.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantasiakuadrat.AppRepository
import com.example.plantasiakuadrat.data.local.AppDatabase
import com.example.plantasiakuadrat.data.local.entity.UserEntity
import com.example.plantasiakuadrat.di.repositoryModule
import kotlinx.coroutines.launch

class RegisterViewModel (private val appRepository: AppRepository): ViewModel() {
//    private val appRepository: AppRepository
//    private val appDatabase: AppDatabase
//    init {
//        appDatabase = AppDatabase.getInstance(application)!!
//        appRepository = AppRepository(appDatabase)
//    }
    private val isRegister = MutableLiveData<Boolean>()
    fun observeIsRegister(): LiveData<Boolean> = isRegister
//    suspend fun insertUser(userEntity: UserEntity){
//        appRepository.insertUser(userEntity)
//    }
    fun insertUser(user: UserEntity){
        viewModelScope.launch {
            try{
                appRepository.insertUser(user)
                isRegister.postValue(true)
            } catch (e: Throwable){
                e.printStackTrace()
            }
        }
    }
}