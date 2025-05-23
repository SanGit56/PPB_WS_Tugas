package com.example.ppb_250423_tugas7

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ppb_250423_tugas7.ui.theme.PPB_250423_Tugas7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PPB_250423_Tugas7Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LamanMasuk()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LamanMasuk(){
    var surel by remember {mutableStateOf("")}
    var sandi by remember {mutableStateOf("")}
    var popupModal by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )

        Text(text = "Selamat datang", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Masuk ke akun anda")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = surel,
            onValueChange = { surel = it },
            label = { Text(text = "Alamat Surel") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = sandi,
            onValueChange = { sandi = it },
            label = { Text(text = "Kata Sandi") },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                Log.i("Credential", "Surel : $surel Sandi : $sandi")
                popupModal = true
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            )
        ) {
            Text(text = "Masuk")
        }
        Spacer(modifier = Modifier.height(32.dp))

        if (popupModal) {
            AlertDialog(
                onDismissRequest = { popupModal = false },
                text = {
                    Text(text = "Surel : $surel Sandi : $sandi")
                },
                confirmButton = {
                    Button(onClick = { popupModal = false }) {
                        Text("Lanjut")
                    }
                }
            )
        }

        Text(
            text = "Lupa Sandi",
            modifier = Modifier.clickable {},
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Masuk dengan")

        Row(
            modifier = Modifier.fillMaxWidth().padding(40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "Facebook",
                modifier = Modifier.size(60.dp).clickable {}
            )

            Image(
                painter = painterResource(id = R.drawable.gugel),
                contentDescription = "Google",
                modifier = Modifier.size(60.dp).clickable {}
            )

            Image(
                painter = painterResource(id = R.drawable.tw),
                contentDescription = "Twitter",
                modifier = Modifier.size(60.dp).clickable {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LamanMasukPreview() {
    PPB_250423_Tugas7Theme {
        LamanMasuk()
    }
}