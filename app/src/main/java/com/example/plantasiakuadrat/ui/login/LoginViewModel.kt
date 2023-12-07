package com.example.plantasiakuadrat.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantasiakuadrat.AppRepository
import com.example.plantasiakuadrat.data.local.AppDatabase
import com.example.plantasiakuadrat.data.local.entity.UserEntity
import kotlinx.coroutines.launch

class LoginViewModel (private val appRepository: AppRepository): ViewModel() {
//    private val appRepository: AppRepository
//    private val appDatabase: AppDatabase
//    init {
//        appDatabase = AppDatabase.getInstance(application)!!
//        appRepository = AppRepository(appDatabase)
//    }
//    suspend fun getUser(email : String, password : String){
//        appRepository.getUser(email, password)
//    }
    private val isLogin = MutableLiveData<UserEntity?>()
    fun observeIsLogin() : LiveData<UserEntity?> = isLogin

    fun getDataLogin(email: String, password : String){
        viewModelScope.launch {
            when(val result = appRepository.getUser(email, password)){
                is UserEntity -> {
                    isLogin.postValue(result)
                }
            }
        }
    }
}
