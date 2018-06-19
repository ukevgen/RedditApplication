package com.example.reddit.android.di.module

import android.app.Application
import android.content.Context
import com.example.reddit.android.di.qualifier.AppQualifier
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ApplicationModule(val application: Application) {

    @Provides
    @Singleton
    @AppQualifier
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @AppQualifier
    fun provideContext(): Context = application.applicationContext

}