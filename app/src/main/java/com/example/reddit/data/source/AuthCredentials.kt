package com.example.reddit.data.source

interface AuthCredentials {
    fun getLogin(): String
    fun getPassword(): String
}