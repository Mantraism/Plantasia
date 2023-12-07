package com.example.plantasiakuadrat.data.remote

class RemoteRepository(private val apiService: ApiService) {
    suspend fun getPlants() = apiService.getPlants()
}