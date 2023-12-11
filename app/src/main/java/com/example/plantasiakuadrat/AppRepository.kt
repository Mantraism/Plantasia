package com.example.plantasiakuadrat

import com.example.plantasiakuadrat.data.local.AppDatabase
import com.example.plantasiakuadrat.data.local.LocalRepository
import com.example.plantasiakuadrat.data.local.entity.UserEntity
import com.example.plantasiakuadrat.data.remote.RemoteRepository

class AppRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {
    suspend fun insertUser(user : UserEntity) {
        localRepository.insertUser(user)
    }
    suspend fun getUser(email : String, password : String): UserEntity? {
        return localRepository.getUser(email,password)
    }
    suspend fun getProfile(email: String): UserEntity {
        return localRepository.getProfile(email)
    }
    suspend fun getPlants() = remoteRepository.getPlants()
}