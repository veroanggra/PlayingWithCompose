package com.veroanggra.migratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.veroanggra.composesubmission.ui.theme.PlayingWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithComposeTheme {
                ConstraintLayout(Modifier.fillMaxSize()) {
                    val (imageFavorite) = createRefs()
                    FavoriteButton(modifier = Modifier.constrainAs(imageFavorite) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    })

                }
            }
        }
    }

    @Composable
    fun FavoriteButton(modifier: Modifier = Modifier) {
        /* Mutable Delegate */
//        var favorite by remember { mutableStateOf(false) }
//        var color by remember { mutableStateOf(Color.Gray) }

//        color = if (favorite) {
//            Color.Red
//        } else {
//            Color.Gray
//        }
//        Image(Icons.Default.Favorite,
//            contentDescription = null,
//            colorFilter = ColorFilter.tint(color),
//            modifier = modifier
//                .size(200.dp)
//                .clickable {
//                    favorite = true
//                    if (color == Color.Red) {
//                        favorite = false
//                    }
//                }
//        )

        // Destructuring
        val (favorite, setFavorite) = remember {
            mutableStateOf(false)
        }
        val (color, setColor) = remember {
            mutableStateOf(Color.Gray)
        }

        setColor(
            if (favorite) {
                Color.Red
            } else {
                Color.Gray
            }
        )

        Image(Icons.Default.Favorite,
            contentDescription = null,
            colorFilter = ColorFilter.tint(color),
            modifier = modifier
                .size(200.dp)
                .clickable {
                    setFavorite(!favorite)
                    if (color == Color.Red) {
                        setFavorite(!favorite)
                    }
                }
        )
    }

}