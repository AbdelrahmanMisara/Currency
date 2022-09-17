package com.blockgemini.data.di

import com.blockgemini.data.remote.CurrencyApiService
import com.blockgemini.data.repository.CurrencyRepositoryImp
import com.blockgemini.domain.repository.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCurrencyRepository(currencyApiService: CurrencyApiService): CurrencyRepository =
        CurrencyRepositoryImp(currencyApiService)
}