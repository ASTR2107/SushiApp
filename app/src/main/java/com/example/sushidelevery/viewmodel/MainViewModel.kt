package com.example.sushidelevery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sushidelevery.model.repository.data.AuthRepository
import com.example.sushidelevery.model.repository.data.NetworkResult
import com.example.sushidelevery.model.repository.data.Retrofit.NewsApiRepository
import com.example.sushidelevery.model.repository.data.UserModel

class MainViewModel(
    private val authRepository: AuthRepository,
    private val newsApiRepository: NewsApiRepository
) : ViewModel() {


}

/*
    init {
        Log.e("AAA", "Created")
    }

    override fun onCleared() {
        Log.e("AAA", "Cleared")
        super.onCleared()
    }

fun init(function: () -> Int) {

}


fun requestNetwork() {
    /*
        val navigationController = rememberNavController()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsApi = retrofit.create(NewsApi::class.java)

        CoroutineScope(Dispatchers.IO).launch { val newsApi = newsApi.getNews() }
        runOnUiThread {


        }
        */
}
}
 */