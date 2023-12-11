package com.example.plantasiakuadrat

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantasiakuadrat.data.local.entity.UserEntity
import kotlinx.coroutines.launch

class ProfileViewModel(private val appRepository: AppRepository): ViewModel() {
    private val getProfile = MutableLiveData<UserEntity>()
    fun observeProfile(): LiveData<UserEntity> = getProfile

    fun getDataProfile(email: String){
        Log.d("getDataProfile" , "${email ?: "Email is null"}")
        viewModelScope.launch {
            when(val result = appRepository.getProfile(email)){
                is UserEntity -> {
                    Log.d("Nama", "Posting profile data: $result")
                    getProfile.postValue(result)
                }
            }
        }
    }

}