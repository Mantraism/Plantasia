package com.example.plantasiakuadrat.di

import com.example.plantasiakuadrat.data.remote.ApiService
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L,TimeUnit.SECONDS)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://trefle.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single {
        createApiService<ApiService>(get())
    }
}
inline fun <reified T>createApiService(retrofit: Retrofit):T = retrofit.create(T::class.java)