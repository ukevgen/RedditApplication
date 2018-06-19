package com.example.reddit.data.remote.retrofit.interceptor

import com.example.reddit.data.source.AuthCredentials
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(private val authCredentials: AuthCredentials) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val builder = request.newBuilder()
        builder.addHeader("Authorization", Credentials.basic(authCredentials.getLogin(), authCredentials.getPassword()))

        return chain.proceed(builder.build())
    }
}