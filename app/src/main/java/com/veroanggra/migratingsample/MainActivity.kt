package com.veroanggra.migratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.veroanggra.composesubmission.ui.theme.DarkGreen
import com.veroanggra.composesubmission.ui.theme.PlayingWithComposeTheme

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

        constrain(firstRect) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
        constrain(secondRect){

        }
    }
    ConstraintLayout(constraintSet = constraint, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(DarkGreen)
                .layoutId("firstRect")
        )
    }
}

@Preview
@Composable
fun PreviewConstraintScreen() {
    ConstraintScreen()
}