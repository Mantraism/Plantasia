package com.example.plantasiakuadrat

import android.app.Application
import com.example.plantasiakuadrat.di.networkModule
import com.example.plantasiakuadrat.di.repositoryModule
import com.example.plantasiakuadrat.di.roomModule
import com.example.plantasiakuadrat.di.viewModelModule
import de.hdodenhof.circleimageview.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules(listOf(
                networkModule,
                repositoryModule,
                roomModule,
                viewModelModule
            ))
        }
    }
}