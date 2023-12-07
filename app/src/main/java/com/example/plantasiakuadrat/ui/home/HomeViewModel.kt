package com.example.plantasiakuadrat.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantasiakuadrat.AppRepository
import com.example.plantasiakuadrat.data.remote.RemoteRepository
import com.example.plantasiakuadrat.data.remote.response.PlantResponse
import com.example.plantasiakuadrat.di.repositoryModule
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class HomeViewModel(private val appRepository: AppRepository): ViewModel() {
    private val getPlant = MutableLiveData<Response<PlantResponse>>()
    val observePlant : LiveData<Response<PlantResponse>> = getPlant

    fun getPlant(){
        viewModelScope.launch {
            Log.d("getPlant","getPlant Function")
            try {
                val result = appRepository.getPlants()
                Log.d("viewModel","getPlant: $result")
                getPlant.postValue(result)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}