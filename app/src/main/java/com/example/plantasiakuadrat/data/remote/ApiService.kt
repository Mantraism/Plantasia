package com.example.plantasiakuadrat.data.remote


import com.example.plantasiakuadrat.data.remote.response.PlantResponse
import com.example.plantasiakuadrat.util.constant.API_KEY
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface ApiService {
    @GET("api/v1/plants?token=HWzjBiQZEHIdTQds1oWAkMSJbYMOWvFKiwbM1xsjvZs")
    suspend fun getPlants(

    ) : Response<PlantResponse>
}