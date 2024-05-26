package com.example.sushidelevery.model.repository.data.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class NetworkServiceImpl : NewsApiRepository {
        private val retrofit = Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val newsApiRepository = retrofit.create(NewsApiRepository::class.java)


}





