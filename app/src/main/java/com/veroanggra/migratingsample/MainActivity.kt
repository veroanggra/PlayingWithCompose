package com.veroanggra.migratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.veroanggra.composesubmission.ui.theme.GreenDarkBackground
import com.veroanggra.composesubmission.ui.theme.GreenLightBackground
import com.veroanggra.composesubmission.ui.theme.PlayingWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithComposeTheme {
                Surface {
                    HomeScreen(Modifier)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier) {
    ConstraintLayout(
        modifier = Modifier
            .background(color = GreenLightBackground)
            .fillMaxSize()
    ) {
        val guidelineLeft = createGuidelineFromAbsoluteLeft(.4f)
        val guidelineBottom = createGuidelineFromTop(.2f)
        val (circleFirst, circleSecond, whiteBackground, topLine) = createRefs()

        CircleBackground(modifier = modifier.constrainAs(circleFirst) {
            bottom.linkTo(guidelineBottom)
            end.linkTo(guidelineLeft)
        }, colors = GreenDarkBackground, size = 300)

        CircleBackground(
            modifier = modifier
                .padding(end = 40.dp, bottom = 40.dp)
                .constrainAs(circleSecond) {
                    bottom.linkTo(guidelineBottom)
                    end.linkTo(guidelineLeft)
                }, colors = GreenLightBackground, size = 300
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp))
                .background(color = Color.White)
                .fillMaxWidth()
                .height(550.dp)
                .constrainAs(whiteBackground) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(color = Color.LightGray)
                .width(50.dp)
                .height(8.dp)
                .constrainAs(topLine) {
                    bottom.linkTo(whiteBackground.top)
                    start.linkTo(whiteBackground.start)
                    end.linkTo(whiteBackground.end)
                }
        )
    }
}

@Composable
fun CircleBackground(modifier: Modifier, colors: Color, size: Int) {
    Canvas(modifier = modifier.size(size.dp), onDraw = {
        drawCircle(color = colors)
    })
}