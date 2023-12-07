package com.example.plantasiakuadrat.data.local

import com.example.plantasiakuadrat.data.local.entity.UserEntity

class LocalRepository(private val appDatabase: AppDatabase) {
    suspend fun insertUser(userEntity: UserEntity){
        appDatabase.userDao().insertUser(userEntity)
    }
    suspend fun getUser(email : String, password : String): UserEntity? {
       return appDatabase.userDao().getUserByEmailAndPassword(email,password)
    }
}