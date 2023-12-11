package com.example.plantasiakuadrat.di

import com.example.plantasiakuadrat.ProfileViewModel
import com.example.plantasiakuadrat.ui.home.HomeViewModel
import com.example.plantasiakuadrat.ui.login.LoginViewModel
import com.example.plantasiakuadrat.ui.register.RegisterViewModel
import okhttp3.internal.cacheGet
import org.koin.dsl.module


val viewModelModule = module {
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
    single { HomeViewModel(get()) }
    single { ProfileViewModel(get()) }
}