package com.example.reddit.data.remote.retrofit.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}