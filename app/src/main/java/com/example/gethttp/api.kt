package com.example.gethttp


import retrofit2.http.GET

interface api {
    @GET("users")
    suspend fun getUsers() : List<User>
}