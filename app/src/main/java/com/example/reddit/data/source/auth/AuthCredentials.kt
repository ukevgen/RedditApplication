package com.example.reddit.data.source.auth

interface AuthCredentials {
    fun getLogin(): String
    fun getPassword(): String
}