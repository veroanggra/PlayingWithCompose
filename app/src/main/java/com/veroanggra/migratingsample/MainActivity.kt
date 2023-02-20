package com.veroanggra.migratingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import com.veroanggra.migratingsample.databinding.ActivityMainBinding
import com.veroanggra.migratingsample.theme.White
import com.veroanggra.migratingsample.widget.InputTextField

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.inputText.setContent {
            Column(modifier = Modifier) {
                InputTextField(
                    modifier = Modifier,
                    hint = "Username",
                    type = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.None,
                    color = White
                )
                InputTextField(
                    modifier = Modifier,
                    hint = "Enter Password",
                    type = KeyboardType.Password,
                    capitalization = KeyboardCapitalization.None,
                    color = White
                )

            }

        }
    }
}