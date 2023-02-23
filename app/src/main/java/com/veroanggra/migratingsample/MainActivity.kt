package com.veroanggra.migratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.veroanggra.composesubmission.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithComposeTheme {
                Surface() {
                    Wallpaper(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun Wallpaper(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = PinkCEAEB1)
            .fillMaxHeight()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(110.dp)
                .background(color = Blue7EA1C4), contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Wed 30 Sep | 09:30", fontSize = 20.sp, textAlign = TextAlign.Center)
                Text(text = "30 °C Cloudy", textAlign = TextAlign.Center)
            }
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(110.dp)
                .background(color = Blue87ACC9)
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(110.dp)
                .background(color = Blue90AFCB)
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(color = Blue9EB6C2)
        )
        Box(contentAlignment = Alignment.BottomEnd) {
            Column() {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = YellowBAC3C3)
                )
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(color = YellowB9B4B0)
                )
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .background(color = Black1D1D32)
                )
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(color = Black202A40)
                )
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .background(color = Orange805350)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.house),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = modifier
                    .padding(end = 50.dp)
                    .width(215.dp),
                contentScale = ContentScale.FillWidth
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight().padding(start = 30.dp, end = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CircleColor(modifier = modifier, color = Black1D1D32)
            CircleColor(modifier = modifier, color = Black202A40)
            CircleColor(modifier = modifier, color = Orange805350)
            CircleColor(modifier = modifier, color = Blue90AFCB)
            CircleColor(modifier = modifier, color = DarkCream)
        }
    }
}

@Composable
fun CircleColor(modifier: Modifier, color: Color) {
    Canvas(modifier = modifier.size(15.dp), onDraw = {
        drawCircle(color = color)
    })
}