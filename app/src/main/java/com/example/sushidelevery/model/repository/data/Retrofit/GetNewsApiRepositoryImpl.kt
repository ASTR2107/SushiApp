package com.example.sushidelevery.model.repository.data.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetNewsApiRepositoryImpl (
){
val interceptor = HttpLoggingInterceptor()
val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

var retrofit = Retrofit.Builder()
    .baseUrl("https://newsapi.org/")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var newsApiRepository = retrofit.create(NewsApiRepository::class.java)

}
