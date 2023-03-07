package com.veroanggra.migratingsample.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.veroanggra.migratingsample.R

@Composable
fun CircleBackground(modifier: Modifier, colors: Color, size: Int) {
    Canvas(modifier = modifier.size(size.dp), onDraw = {
        drawCircle(color = colors)
    })
}

@Composable
fun ImageRounded(modifier: Modifier, image: Int) {
    Image(
        painter = painterResource(id = image), contentDescription = null, modifier = modifier
            .clip(
                RoundedCornerShape(20)
            )
            .width(80.dp)
            .height(80.dp), contentScale = ContentScale.Crop
    )
}

@Composable
fun ImageCircle(modifier: Modifier, image: Int) {
    Image(
        painter = painterResource(id = image), contentDescription = null, modifier = modifier
            .clip(CircleShape)
            .width(70.dp)
            .height(70.dp), contentScale = ContentScale.Crop
    )
}

