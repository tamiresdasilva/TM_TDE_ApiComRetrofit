package com.example.apicomretrofit.data.di

import com.example.apicomretrofit.data.datasources.CharactersDataSource
import com.example.apicomretrofit.data.network.CharactersApi
import com.example.apicomretrofit.data.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun providesDataSourceModule(api: CharactersApi): CharactersDataSource {
        return CharactersDataSource(api)
    }
}