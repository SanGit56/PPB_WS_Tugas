package com.example.ppb_250326_tugas4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ppb_250326_tugas4.ui.theme.PPB_250326_Tugas4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPB_250326_Tugas4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainDadu()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainDadu() {
    PPB_250326_Tugas4Theme {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.latar),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        GambarDanTombol(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)
        )
    }
}

@Composable
fun GambarDanTombol(modifier: Modifier = Modifier) {
    var hasil by remember { mutableStateOf(1) }
    val gambarDadu = when (hasil) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    var rotasi by remember { mutableStateOf(0f) }
    val animasi by animateFloatAsState(
        targetValue = rotasi,
        label = "Rotasi Dadu"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(gambarDadu),
            contentDescription = hasil.toString(),
            modifier = Modifier
                .graphicsLayer(rotationZ = animasi)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Black.copy(alpha = 0.8f))
                .padding(8.dp)
        ) {
            Text(
                text = hasil.toString(),
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                hasil = (1..6).random()
                rotasi -= 360f
                      },
            colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.8f))
        ) {
            Text(stringResource(R.string.gulir))
        }
    }
}