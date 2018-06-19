package com.example.reddit.android.preference

import android.content.SharedPreferences
import com.example.reddit.EmptyConstants
import com.example.reddit.EmptyConstants.EMPTY_STRING
import com.example.reddit.data.source.preference.AppSharedPreferences
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SharedPreferenceProvider @Inject constructor(private val sharedPreferences: SharedPreferences) : AppSharedPreferences {

    companion object {
        const val TAG = "SharedPreferenceProvider"

        val KEY_ACCESS_TOKEN = "com.example.reddit.access_token"
    }

    override fun clear(): Completable {
        return Completable.fromCallable { sharedPreferences.edit().clear().apply() }
    }

    override fun putString(key: String, data: String): Completable {
        return Completable.fromCallable { sharedPreferences.edit().putString(key, data).apply() }
    }

    override fun getString(key: String): Single<String> {
        return Single.fromCallable { sharedPreferences.getString(key, EMPTY_STRING) }
    }

    override fun putInt(key: String, data: Int): Completable {
        return Completable.fromCallable { sharedPreferences.edit().putInt(key, data).apply() }
    }

    override fun getInt(key: String): Single<Int> {
        return Single.fromCallable { sharedPreferences.getInt(key, EmptyConstants.EMPTY_INT) }
    }

    override fun putFloat(key: String, data: Float): Completable {
        return Completable.fromCallable { sharedPreferences.edit().putFloat(key, data).apply() }
    }

    override fun getFloat(key: String): Single<Float> {
        return Single.fromCallable { sharedPreferences.getFloat(key, EmptyConstants.EMPTY_FLOAT) }
    }

    override fun putLong(key: String, data: Long): Completable {
        return Completable.fromCallable { sharedPreferences.edit().putLong(key, data).apply() }
    }

    override fun getLong(key: String): Single<Long> {
        return Single.fromCallable { sharedPreferences.getLong(key, EmptyConstants.EMPTY_LONG) }
    }

    override fun putBool(key: String, data: Boolean): Completable {
        return Completable.fromCallable { sharedPreferences.edit().putBoolean(key, data).apply() }
    }

    override fun getBool(key: String): Single<Boolean> {
        return Single.fromCallable { sharedPreferences.getBoolean(key, EmptyConstants.EMPTY_BOOL) }
    }

    override fun remove(key: String): Completable {
        return Completable.fromCallable { sharedPreferences.edit().remove(key).apply() }
    }

    override fun contains(key: String): Single<Boolean> {
        return Single.fromCallable { sharedPreferences.contains(key) }
    }


}