package com.example.sushidelevery.model.repository.data

import com.google.firebase.auth.FirebaseAuth

interface AuthRepository {
    suspend fun firebaseSignUp(user: UserModel): kotlinx.coroutines.flow.Flow<NetworkResult<Boolean>>
    suspend fun firebaseLogIn(email: String, password: String): kotlinx.coroutines.flow.Flow<NetworkResult<Boolean>>


}