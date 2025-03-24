package com.example.a5025211166_happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a5025211166_happybirthday.ui.theme._5025211166_HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _5025211166_HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TeksUcapan(
                        pesan = "Selamat Ulang Tahun, Kamu",
                        dari = "San",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TeksUcapan(pesan: String, dari: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = pesan,
            fontSize = 70.sp,
            lineHeight = 70.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = dari,
            fontSize = 30.sp,
            modifier = Modifier.padding(16.dp).align(alignment = Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KartuUltahPreview() {
    _5025211166_HappyBirthdayTheme {
        TeksUcapan(pesan = "Selamat Ulang Tahun, Kamu", dari = "San")
    }
}