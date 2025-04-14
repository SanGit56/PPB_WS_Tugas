package com.example.ppb_250916_tugas6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ppb_250916_tugas6.ui.theme.PPB_250916_Tugas6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPB_250916_Tugas6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFe0c3cd)
                ) {
                    KonversiKurs()
                }
            }
        }
    }
}

@Composable
fun KonversiKurs() {
    val dollarKeRupiah = mapOf(
        "USD" to 16777f,
        "AUD" to 10569.5f,
        "CAD" to 12098.2f,
        "NZD" to 9822.5f,
        "SGD" to 12756.2f,
        "HKD" to 2163.27f,
        "FJD" to 7268.28f,
        "JMD" to 106.48f,
        "TTD" to 2476.54f,
        "NAD" to 882.93f
    )

    var jumlah by remember { mutableStateOf("") }
    var mataUangTerpilih by remember { mutableStateOf("USD") }
    var perluas by remember { mutableStateOf(false) }
    var idr by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            TextField(
                value = jumlah,
                onValueChange = {
                    jumlah = it
                    val jml = jumlah.toFloatOrNull() ?: 0f
                    val dolar = dollarKeRupiah[mataUangTerpilih] ?: 1f
                    idr = jml * dolar
                },
                label = { Text("Jumlah: ") }
            )

            Box {
                Button(
                    onClick = { perluas = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF9A3A5B)
                    )
                ) {
                    Text(text = mataUangTerpilih)
                }

                DropdownMenu(
                    expanded = perluas,
                    onDismissRequest = { perluas = false }
                ) {
                    dollarKeRupiah.keys.forEach { mataUang ->
                        DropdownMenuItem(
                            text = { Text(text = mataUang) },
                            onClick = {
                                mataUangTerpilih = mataUang
                                perluas = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color(0xFF9A3A5B))
        ) {
            Text(
                text = "$jumlah $mataUangTerpilih = $idr Rupiah",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KonversiKursPreview() {
    PPB_250916_Tugas6Theme {
        KonversiKurs()
    }
}