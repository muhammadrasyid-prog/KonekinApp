package com.android.konekinn.network

import com.android.konekinn.model.UserDetail
import com.android.konekinn.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("employees")
    fun getAllUsers(): Call<Users>

    @GET("employee/{id}")
    fun getUserById(@Path("id") id: Int): Call<UserDetail>
}