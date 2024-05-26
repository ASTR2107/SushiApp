package com.example.sushidelevery.model.repository.data.Retrofit

import com.example.sushidelevery.model.repository.data.Retrofit.model.AuthRequest
import com.example.sushidelevery.model.repository.data.Retrofit.model.NewsData
import com.example.sushidelevery.model.repository.data.Retrofit.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface NewsApiRepository {
    @GET("v2/everything")
    suspend fun getNews(): Call<List<NewsData>>

   @POST("auth/login")
   suspend fun getAuth(@Body authRequest: AuthRequest): User


}

