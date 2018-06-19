package com.example.reddit.data.cache

import com.example.reddit.android.preference.SharedPreferenceProvider.Companion.KEY_ACCESS_TOKEN
import com.example.reddit.data.datasource.AuthLocalDataSource
import com.example.reddit.data.source.preference.AppSharedPreferences
import io.reactivex.Completable
import javax.inject.Inject

class AuthLocalDataSourceImpl @Inject constructor(private val preferenceProvider: AppSharedPreferences) : AuthLocalDataSource {

    override fun updateToken(token: String): Completable {
        return preferenceProvider.putString(KEY_ACCESS_TOKEN, token)
    }
}