package com.example.plantasiakuadrat.di

import com.example.plantasiakuadrat.AppRepository
import com.example.plantasiakuadrat.data.local.LocalRepository
import com.example.plantasiakuadrat.data.remote.RemoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalRepository(get()) }
    single { RemoteRepository(get()) }
    single { AppRepository(get(),get()) }
}