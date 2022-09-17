package com.blockgemini.data.di

import com.blockgemini.data.remote.CurrencyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): CurrencyApiService =
        retrofit.create(CurrencyApiService::class.java)
}