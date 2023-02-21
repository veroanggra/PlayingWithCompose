package com.veroanggra.migratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.veroanggra.composesubmission.ui.theme.PlayingWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithComposeTheme{
                Surface {
                    ColumnArrange()
                }
            }
        }
    }
}

@Composable
fun ColumnArrange() {
    Column() {
        Text(text = "Column1")
        Text(text = "Column2")
        Text(text = "Column3")
        Text(text = "Column4")
        Text(text = "Column5")
    }
}