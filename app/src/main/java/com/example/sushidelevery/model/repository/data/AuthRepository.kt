package com.example.sushidelevery.model.repository.data

interface AuthRepository {
    suspend fun firebaseSignUp(user: UserModel): kotlinx.coroutines.flow.Flow<NetworkResult<Boolean>>
    suspend fun firebaseLogIn(email: UserModel, password: String): kotlinx.coroutines.flow.Flow<NetworkResult<Boolean>>

}