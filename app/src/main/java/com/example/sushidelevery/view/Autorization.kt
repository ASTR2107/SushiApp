package com.example.sushidelevery.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sushidelevery.ui.theme.Green30
import com.example.sushidelevery.viewmodel.MainViewModel

@Composable
fun Autorization(onClick: () -> Unit) {

    val viewModel: MainViewModel = viewModel()
    val login = remember {
        mutableStateOf("")
    }
    val phone = remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Green30)
    ) {
        Text(
            text = "Hello User",
            color = Color.White,
            fontSize = (25.sp),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = login.value,
            onValueChange = { login.value = it },
            placeholder = { Text(text = "Login") },
            singleLine = true,

            )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            phone.value,
            { phone.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Пройти дальше",
                fontSize = (23.sp),
                color = Color.White,
                modifier = Modifier.padding(end = 10.dp),
            )

            Button(
                onClick = { onClick() },
                modifier = Modifier,
            ) {
                Text(text = "Sing Up")

            }

        }
        TextButton(onClick = {
            onClick()
        }) {
            Text(
                text = "Продолжить без регистрации",
                color = Color.Blue,
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
            IconButton(onClick = { /*TODO*/ }) {
                Icons.Filled.MailOutline
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icons.Filled.MailOutline

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icons.Filled.MailOutline

            }


        }
    }
}


