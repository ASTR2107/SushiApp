package com.example.sushidelevery.ui.theme.usecase

import com.example.sushidelevery.model.repository.data.AuthRepository
import com.example.sushidelevery.model.repository.data.UserModel
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun registerNewUser(userModel: UserModel) =
        repository.firebaseSignUp(user = userModel)

    suspend fun loginUser(email: String, password: String) =
        repository.firebaseLogIn(email,password)


}