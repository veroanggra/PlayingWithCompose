package com.veroanggra.migratingsample.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.veroanggra.migratingsample.R
import com.veroanggra.migratingsample.theme.White

@Composable
fun ImageSignIn(modifier: Modifier, image: Int) {
    Card(
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = modifier
            .width(70.dp)
            .height(50.dp),
        border = BorderStroke(1.dp, White)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun PreviewImageSignIn() {
    ImageSignIn(modifier = Modifier, R.drawable.google)
}