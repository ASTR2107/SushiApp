package com.example.sushidelevery.di.modules

import com.example.sushidelevery.model.repository.data.AuthRepository
import com.example.sushidelevery.model.repository.data.AuthRepositoryImpl
import com.example.sushidelevery.model.repository.data.UserModel
import com.example.sushidelevery.ui.theme.usecase.AuthUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Singleton
    @Provides
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideRepository(firebaseAuth: FirebaseAuth,firebaseFirestore: FirebaseFirestore) =
        AuthRepositoryImpl(firebaseAuth, firebaseFirestore)

    @Singleton
    @Provides
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(authRepository)

}