package com.example.check_percentage.di

import com.example.data.remote.api.LoveCalculatorApi
import com.example.data.repository.remote.datasource.MainDataSource
import com.example.data.repository.remote.datasource.SplashDataSource
import com.example.data.repository.remote.datasourceImpl.MainDataSourceImpl
import com.example.data.repository.remote.datasourceImpl.SplashDataSourceImpl
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun provideMainDataSource(
        loveCalculatorApi: LoveCalculatorApi,
    ): MainDataSource {
        return MainDataSourceImpl(
            loveCalculatorApi
        )
    }

    @Provides
    fun provideSplashDataSource(
        firebaseRtdb: FirebaseDatabase,
        fireStore: FirebaseFirestore
    ): SplashDataSource {
        return SplashDataSourceImpl(firebaseRtdb, fireStore)
    }
}