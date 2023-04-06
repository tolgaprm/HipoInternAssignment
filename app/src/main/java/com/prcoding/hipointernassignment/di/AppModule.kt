package com.prcoding.hipointernassignment.di

import com.prcoding.hipointernassignment.data.remote.HipoApi
import com.prcoding.hipointernassignment.data.repository.HipoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHipoApi(): HipoApi {
        return Retrofit.Builder()
            .baseUrl(HipoApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(HipoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHipoRepository(
        api: HipoApi
    ): HipoRepository {
        return HipoRepository(api)
    }
}