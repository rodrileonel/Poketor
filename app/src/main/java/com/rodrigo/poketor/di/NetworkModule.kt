package com.rodrigo.poketor.di

import com.rodrigo.poketor.data.PoketorApi
import com.rodrigo.poketor.data.PoketorRepository
import com.rodrigo.poketor.data.PoketorRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl("https://api.pokemontcg.io/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApi(retrofit: Retrofit): PoketorApi = retrofit.create(PoketorApi::class.java)

    @Provides
    fun provideRepository(api: PoketorApi): PoketorRepository = PoketorRepositoryImpl(api)
}