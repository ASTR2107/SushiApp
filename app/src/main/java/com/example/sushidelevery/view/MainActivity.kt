package com.example.sushidelevery.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sushidelevery.R
import com.example.sushidelevery.view.data.Menu
import com.example.sushidelevery.viewmodel.MainViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream


class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    private lateinit var mainViewModel: MainViewModel

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fs = Firebase.firestore
        fs.collection("menu")
            .document()


        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        e("AAA", "Created")
        setContent {
            MenuScreen()
        }
    }
}


/*
val navController = rememberNavController()
NavHost(navController = navController, startDestination = "menu_screen") {

    composable("home_screens") {
        HomeScreens {
            navController.navigate("autorization")
        }
    }
    composable("autorization") {
        Autorization {
            navController.navigate("news")
        }
    }
    composable("news") {
        News {
        }
    }*/

@Preview(showBackground = true)
@Composable
fun MenuScreen() {
    val context = LocalContext.current
    val fs = Firebase.firestore
    val storage = Firebase.storage.reference.child("images")
    val list = remember {
        mutableStateOf(emptyList<Menu>())
    }
    val listener = fs.collection("menu")
        .addSnapshotListener { snapShot, exeption ->
            if (snapShot != null) {
                list.value = snapShot
                    .toObjects(Menu::class.java) ?: emptyList()
            }
        }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.FixedSize(size = 140.dp),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            items(list.value) { menu ->
                Row {

                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            val task = storage.child("plant16").putBytes(
                bitmapToByteArray(context)
            )
            task.addOnSuccessListener {uploadTask ->
                uploadTask.metadata?.reference
                    ?.downloadUrl?.addOnCompleteListener {urilTask ->
                        saveMenu(fs,urilTask.result.toString())
                }


            }
        }
        ) {
            Text(text = "Name")
        }


    }
}
private fun bitmapToByteArray(context: Context): ByteArray{
    val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.plants)
    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
    return baos.toByteArray()

}

private fun saveMenu(fs: FirebaseFirestore, url: String){

    fs.collection("menu")
        .document().set(
            Menu(
                "Сет Philadelphia 8.шт",
                "Bla",
                "Лосось, Икра, Огурец",
                "400р",
                "Роллы",
                url
            )
        )
}







