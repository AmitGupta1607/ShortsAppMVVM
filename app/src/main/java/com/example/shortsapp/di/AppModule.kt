package com.example.shortsapp.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.shortsapp.common.Constants
import com.example.shortsapp.data.MemeFetchApi
import com.example.shortsapp.data.MemeRepositoryImpl
import com.example.shortsapp.domain.MemeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {


    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesMemeFetchApi(retrofit: Retrofit) =
        retrofit.create(MemeFetchApi::class.java)

    @Provides
    fun providesRepository(memeFetchApi: MemeFetchApi): MemeRepository {
        return MemeRepositoryImpl(memeFetchApi)
    }

    @Provides
    fun providesRequestManager(@ApplicationContext context:Context):RequestManager{
        return Glide.with(context)
    }
}