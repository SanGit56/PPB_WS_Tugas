package com.example.ppb_250409_tugas5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ppb_250409_tugas5.ui.theme.PPB_250409_Tugas5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPB_250409_Tugas5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFe0dcec)
                ) {
                    Kalkulator()
                }
            }
        }
    }
}

@Composable
fun Kalkulator() {
    var angka1 by remember { mutableFloatStateOf(0f) }
    var angka2 by remember { mutableFloatStateOf(0f) }
    var hasil by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color(0xFFa396c8))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${angka1.toInt()}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Slider(
                    value = angka1,
                    onValueChange = { newValue -> angka1 = newValue },
                    valueRange = 0f..100f,
                    steps = 99,
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFF6650a4),
                        thumbColor = Color(0xFF6650a4)
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color(0xFFa396c8))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${angka2.toInt()}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Slider(
                    value = angka2,
                    onValueChange = { newValue -> angka2 = newValue },
                    valueRange = 0f..100f,
                    steps = 99,
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFF6650a4),
                        thumbColor = Color(0xFF6650a4)
                    )
                )
            }
        }

        Row {
            Button(
                onClick = { hasil = angka1 + angka2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6650a4)
                )
            ) {
                Text(
                    text = "+",
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { hasil = angka1 + angka2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6650a4)
                )
            ) {
                Text(
                    text = "-",
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { hasil = angka1 + angka2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6650a4)
                )
            ) {
                Text(
                    text = "x",
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { hasil = angka1 + angka2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6650a4)
                )
            ) {
                Text(
                    text = "/",
                    fontSize = 24.sp
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color(0xFFa396c8))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = hasil.toString()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KalkulatorPreview() {
    PPB_250409_Tugas5Theme {
        Kalkulator()
    }
}