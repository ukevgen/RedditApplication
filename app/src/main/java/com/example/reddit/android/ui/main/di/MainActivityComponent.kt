package com.example.reddit.android.ui.main.di

import android.support.v7.app.AppCompatActivity
import com.example.reddit.android.di.scopes.PerActivity
import com.example.reddit.android.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerActivity
@Subcomponent(modules = [
    (MainActivityComponent.ActivityBindsModule::class),
    (MainActivityComponent.FragmentBindingsModule::class),
    (MainActivityComponent.ActivityModule::class),
    (MainActivityComponent.BindingsModule::class)
])
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

    @Module
    interface ActivityBindsModule {

        @Binds
        fun provideActivityModule(activity: MainActivity): AppCompatActivity

    }

    @Module
    class ActivityModule {

    }

    @Module(subcomponents = [

    ])
    interface FragmentBindingsModule {

    }

    @Module
    interface BindingsModule {

    }
}