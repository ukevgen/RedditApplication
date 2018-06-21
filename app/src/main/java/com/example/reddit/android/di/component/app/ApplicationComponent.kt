package com.example.reddit.android.di.component.app

import android.app.Activity
import com.example.reddit.RedditApplication
import com.example.reddit.android.di.module.AndroidModule
import com.example.reddit.android.di.module.ApplicationModule
import com.example.reddit.android.di.module.GlideApplicationModule
import com.example.reddit.android.ui.main.MainActivity
import com.example.reddit.android.ui.main.di.MainActivityComponent
import com.example.reddit.data.cache.di.CacheModule
import com.example.reddit.data.di.DataModule
import com.example.reddit.data.remote.di.RemoteModule
import com.example.reddit.data.remote.retrofit.di.NetModule
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (ApplicationModule::class),
    (AndroidModule::class),
    (DataModule::class),
    (GlideApplicationModule::class),
    (CacheModule::class),
    (NetModule::class),
    (RemoteModule::class),
    (AndroidSupportInjectionModule::class),
    (ApplicationComponent.ActivityBindingsModule::class),
    (ApplicationComponent.FragmentBindingsModule::class),
    (ApplicationComponent.ServiceBindingsModule::class)
])
interface ApplicationComponent : AndroidInjector<RedditApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<RedditApplication>() {
        abstract fun applicationModule(module: ApplicationModule): Builder
    }

    @Module(subcomponents = [
        (MainActivityComponent::class)
    ])
    interface ActivityBindingsModule {

        @Binds
        @IntoMap
        @ActivityKey(value = MainActivity::class)
        fun mainActivityComponentBuilder(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    }

    @Module(subcomponents = [

    ])
    interface FragmentBindingsModule {

    }

    @Module(subcomponents = [

    ])
    interface ServiceBindingsModule {

    }
}