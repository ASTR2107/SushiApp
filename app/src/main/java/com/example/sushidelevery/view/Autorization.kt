@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.sushidelevery.view

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sushidelevery.model.repository.data.AuthRepository
import com.example.sushidelevery.model.repository.data.AuthRepositoryImpl
import com.example.sushidelevery.ui.theme.Green30
import com.example.sushidelevery.view.components.TabLayout
import com.example.sushidelevery.viewmodel.MainViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

@Composable
fun Autorization(
    viewModel: MainViewModel?,
    navController: NavController
) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE)
    val authResult = viewModel?.loginFlow?.collectAsState()

    val selectTab = remember {
        mutableStateOf(0)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Green30)
    ) {
        TabLayout(selectIndex = selectTab.value,
            items = listOf(
                "Sign In" to {
                    SignIn(
                        navController = navController,
                        sharedPreferences = sharedPreferences
                    ){}
                },
                "Sign Up" to {
                    SignUp(
                        navController = navController,
                        sharedPreferences = sharedPreferences
                    ) {}

                }
            ),
            onTabClick = {
                selectTab.value = it
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(
    navController: NavController,
    sharedPreferences: SharedPreferences,
    trailing: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onClick: () -> Unit
){
    val auth = Firebase.auth
    val meChecked = remember {
        mutableStateOf(false)
    }
    val phone = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val showPassword = remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Hello User",
            color = Color.White,
            fontSize = (25.sp),
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = phone.value,
            singleLine = true,
            onValueChange = { phone.value = it },
            placeholder = { Text(text = "Phone") },
            visualTransformation = visualTransformation

        )
        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = password.value,
            singleLine = true,
            onValueChange = { password.value = it },
            placeholder = { Text(text = "Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

            )

        Spacer(modifier = Modifier.padding(4.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                Checkbox(checked = meChecked.value, onCheckedChange = {
                    meChecked.value = it
                })

            }
            Text(
                text = "Запомнить меня",
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp),
                onClick = {

                    sharedPreferences.edit().apply {
                        putBoolean("", true)
                        putString("phone", phone.value)
                    }
                        .apply()
                    navController.navigate("home") {
                        popUpTo(0)
                    }
                }
            )
            {
                Text(
                    text = "Вход",
                    fontSize = (23.sp),
                    color = Color.White,
                    modifier = Modifier.padding(end = 10.dp),
                )

            }


        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(
    navController: NavController,
    sharedPreferences: SharedPreferences,
    trailing: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onClick: () -> Unit
) {
    val firebaseAuth: FirebaseAuth
    val firebaseFirestore: FirebaseFirestore
    val meChecked = remember {
        mutableStateOf(false)
    }
    val phone = remember {
        mutableStateOf("")
    }
    val passwordRepeat = remember {
        mutableStateOf("")
    }
    val showPassword = remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Hello User",
            color = Color.White,
            fontSize = (25.sp),
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = phone.value,
            singleLine = true,
            onValueChange = { phone.value = it },
            placeholder = { Text(text = "Phone") },
            visualTransformation = visualTransformation

        )
        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = passwordRepeat.value,
            singleLine = true,
            onValueChange = { passwordRepeat.value = it },
            placeholder = { Text(text = "Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

            )

        Spacer(modifier = Modifier.padding(4.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                Checkbox(checked = meChecked.value, onCheckedChange = {
                    meChecked.value = it
                })

            }
            Text(
                text = "Запомнить меня",
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp),
                onClick = {


                    sharedPreferences.edit().apply {
                        putBoolean("", true)
                        putString("phone", phone.value)
                    }
                        .apply()
                    navController.navigate("home") {
                        popUpTo(0)
                    }
                }
            )
            {
                Text(
                    text = "Регистрация",
                    fontSize = (23.sp),
                    color = Color.White,
                    modifier = Modifier.padding(end = 10.dp),
                )

            }
            Text(
                text = "Другой метод регистрации",
                color = Color.White,
                modifier = Modifier.padding(top = 20.dp),
                textDecoration = TextDecoration.Underline
            )

            Row(
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            ) {
                IconButton(onClick = { }) {
                    Icons.Filled.MailOutline
                }
                IconButton(onClick = { }) {
                    Icons.Filled.MailOutline

                }
                IconButton(onClick = { }) {
                    Icons.Filled.MailOutline

                }

            }
        }
    }
}
/*
@Composable
fun AppTextFiled(
    visualTransformation: VisualTransformation = VisualTransformation.None
) {}*/


















