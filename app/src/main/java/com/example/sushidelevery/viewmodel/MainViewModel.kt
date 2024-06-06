package com.example.sushidelevery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sushidelevery.model.repository.data.AuthRepository
import com.example.sushidelevery.model.repository.data.NetworkResult
import com.example.sushidelevery.model.repository.data.NetworkResult.Loading
import com.example.sushidelevery.model.repository.data.Retrofit.NewsApiRepository
import com.example.sushidelevery.model.repository.data.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User
import com.google.rpc.context.AttributeContext.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val authRepository: AuthRepository,
    private val newsApiRepository: NewsApiRepository
) : ViewModel() {
    private val _loginFlow = MutableStateFlow<NetworkResult<UserModel>?>(null)
    val loginFlow: StateFlow<NetworkResult<UserModel>?> = _loginFlow

    private val _signUpFlow = MutableStateFlow<NetworkResult<UserModel>?>(null)
    val signUpFlow: StateFlow<NetworkResult<UserModel>?> = _signUpFlow

    val currentUser: UserModel?
        get() = authRepository.currentUser

    init {
        if (authRepository.currentUser != null) {
            _loginFlow.value = NetworkResult.Success(authRepository.currentUser!!)
        }
    }

    fun loginUser(email: String, password: String) = viewModelScope
        .launch {
            _loginFlow.value = NetworkResult.Loading()
            authRepository.firebaseLogIn(email,password)
             _loginFlow.value = return@launch
    }

    fun signUpUser(userModel: UserModel) = viewModelScope
        .launch {
            _signUpFlow.value = NetworkResult.Loading()
            authRepository.firebaseSignUp(userModel)
            _signUpFlow.value = return@launch
        }
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