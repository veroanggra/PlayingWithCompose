package com.veroanggra.migratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.veroanggra.composesubmission.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithComposeTheme {
                Surface {
                    ConstraintScreen()
                }
            }
        }
    }
}

@Composable
fun ConstraintScreen() {
    val constraint = ConstraintSet {
        val firstRect = createRefFor("firstRect")
        val secondRect = createRefFor("secondRect")
        val thirdRect = createRefFor("thirdRect")
        val fourthRect = createRefFor("fourthRect")
        val fifthRect = createRefFor("fifthRect")
        val sixRect = createRefFor("sixRect")
        val sevenRect = createRefFor("sevenRect")
        val guideline = createGuidelineFromBottom(0.1f)


        constrain(firstRect) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
        constrain(secondRect) {
            top.linkTo(firstRect.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
        constrain(thirdRect) {
            top.linkTo(firstRect.bottom)
            start.linkTo(secondRect.end)
            end.linkTo(parent.end)
            width = Dimension.percent(1f)
            height = Dimension.value(100.dp)
        }
        constrain(fourthRect) {
            top.linkTo(secondRect.bottom)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(fifthRect) {
            top.linkTo(secondRect.bottom)
            start.linkTo(fourthRect.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
//        constrain(sixRect) {
//            bottom.linkTo(guideline)
//            start.linkTo(parent.start)
//            width = Dimension.value(100.dp)
//            height = Dimension.value(100.dp)
//        }
//        constrain(sevenRect) {
//            bottom.linkTo(guideline)
//            start.linkTo(sixRect.end)
//            end.linkTo(parent.end)
//            width = Dimension.value(100.dp)
//            height = Dimension.value(100.dp)
//        }
//        createHorizontalChain(fourthRect, fifthRect, chainStyle = ChainStyle.Spread)
//        createHorizontalChain(fourthRect, fifthRect, chainStyle = ChainStyle.SpreadInside)
        createHorizontalChain(fourthRect, fifthRect, chainStyle = ChainStyle.Packed)
        createHorizontalChain(sixRect, sevenRect, chainStyle = ChainStyle.Spread)

    }
    ConstraintLayout(constraintSet = constraint, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(DarkGreen)
                .layoutId("firstRect")
        )
        Box(
            modifier = Modifier
                .layoutId("secondRect")
                .background(Cream)
        )
        Box(
            modifier = Modifier
                .layoutId("thirdRect")
                .background(YellowPickerColor)
        )
        Box(
            modifier = Modifier
                .layoutId("fourthRect")
                .background(GreenPickerColor)
        )
        Box(
            modifier = Modifier
                .layoutId("fifthRect")
                .background(Purple40)
        )
        Box(
            modifier = Modifier
                .layoutId("sixRect")
                .background(Pink40)
        )
        Box(
            modifier = Modifier
                .layoutId("sevenRect")
                .background(NeonGreen)
        )
    }
}

@Preview
@Composable
fun PreviewConstraintScreen() {
    ConstraintScreen()
}