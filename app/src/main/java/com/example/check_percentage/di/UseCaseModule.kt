package com.example.check_percentage.di

import com.example.domain.repository.MainRepository
import com.example.domain.repository.SplashRepository
import com.example.domain.usecase.CheckAppVersionUseCase
import com.example.domain.usecase.CheckLoveCalculatorUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideCheckLoveCalculatorUseCase(repository: MainRepository) = CheckLoveCalculatorUseCase(repository)

    @Provides
    fun provideCheckAppVersionUseCase(repository: SplashRepository) = CheckAppVersionUseCase(repository)

}