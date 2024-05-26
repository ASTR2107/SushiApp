package com.example.sushidelevery.model.repository.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    val TAG = "AuthRepositoryImpl"

    override suspend fun firebaseSignUp(user: UserModel): Flow<NetworkResult<Boolean>> {
        return flow {
            var isSuccess = false
            emit(NetworkResult.Loading())

            try {
                firebaseAuth.createUserWithEmailAndPassword(user.login, user.password)
                    .addOnCompleteListener { task ->
                        isSuccess = if (task.isSuccessful) {
                            Log.d(TAG, "createUserWithEmailAndPassword:: success")
                            val firebaseUser = firebaseAuth.currentUser
                            if (firebaseUser != null) {
                                user.userId = firebaseUser.uid
                            }
                            firebaseUser != null
                        } else {
                            Log.d(TAG, "createUserWithEmailAndPassword:: failure", task.exception)
                            false

                        }
                    }.await()
                if (isSuccess) {
                    emit(NetworkResult.Success(true))
                } else {
                    emit(NetworkResult.Error("Oh"))
                }

            } catch (e: Exception) {
                emit(NetworkResult.Error(message = e.localizedMessage ?: "Oh"))
            }


        }
    }


    override suspend fun firebaseLogIn(
        email: UserModel,
        password: String
    ): Flow<NetworkResult<Boolean>> {
        return flow {
            var isSuccess = false

            emit(NetworkResult.Loading())

            try {
                firebaseAuth.signInWithEmailAndPassword(email.toString(), password)
                    .addOnCompleteListener { task ->
                        isSuccess = if (task.isSuccessful) {
                            Log.d(TAG, "signInWithEmailAndPassword:: success")
                            firebaseAuth.currentUser != null
                        } else {
                            Log.d(TAG, "signInWithEmailAndPassword:: success")
                            false
                        }

                    }.await()




                if (isSuccess) {
                    emit(NetworkResult.Success(true))
                } else {
                    emit(NetworkResult.Error("Oh"))
                }

            } catch (e: Exception) {
                emit(NetworkResult.Error(message = e.localizedMessage ?: "Oh"))
            }

        }

    }
}