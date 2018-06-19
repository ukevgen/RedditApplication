package com.example.reddit.data.source.preference

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.annotations.NonNull
import io.reactivex.annotations.Nullable

interface AppSharedPreferences {
    fun putString(@NonNull key: String, @Nullable data: String): Completable
    fun getString(@NonNull key: String): Single<String>
    fun putInt(@NonNull key: String, @Nullable data: Int): Completable
    fun getInt(@NonNull key: String): Single<Int>
    fun putFloat(@NonNull key: String, @Nullable data: Float): Completable
    fun getFloat(@NonNull key: String): Single<Float>
    fun putLong(@NonNull key: String, @Nullable data: Long): Completable
    fun getLong(@NonNull key: String): Single<Long>
    fun putBool(@NonNull key: String, @Nullable data: Boolean): Completable
    fun getBool(@NonNull key: String): Single<Boolean>
    fun remove(@NonNull key: String): Completable
    fun contains(@NonNull key: String): Single<Boolean>
    fun clear(): Completable
}