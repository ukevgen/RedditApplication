package com.example.reddit.data.remote.retrofit.di

import com.example.reddit.android.di.qualifier.network.RedditQualifier
import com.example.reddit.data.remote.retrofit.interceptor.HeaderInterceptor
import com.example.reddit.data.remote.retrofit.service.AuthService
import com.example.reddit.data.remote.retrofit.service.RedditService
import com.example.reddit.data.source.auth.AuthCredentials
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {


    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor,
                            headerInterceptor: HeaderInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(headerInterceptor)
                    .build()


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://www.reddit.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }


    @Singleton
    @Provides
    @RedditQualifier
    fun provideRedditRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://www.reddit.com/r/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    // Creds

    @Singleton
    @Provides
    fun provideApiCredentials(): AuthCredentials {
        return object : AuthCredentials {
            override fun getLogin() = "JY-YKdvHMmUabg"
            override fun getPassword() = "e6QGEqPBfBiVU3F1by3W7AJjKo0"
        }
    }

    // Services

    @Singleton
    @Provides
    fun provideTokenService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)

    @Singleton
    @Provides
    fun provideRedditService(@RedditQualifier retrofit: Retrofit): RedditService = retrofit.create(RedditService::class.java)
}