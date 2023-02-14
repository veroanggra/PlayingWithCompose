package com.veroanggra.migratingsample.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.veroanggra.migratingsample.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    modifier: Modifier,
    hint: String,
    type: KeyboardType,
    capitalization: KeyboardCapitalization, color: Color
) {
    var inputValue by remember { mutableStateOf(TextFieldValue()) }
    var passwordMode by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = inputValue,
        onValueChange = { inputValue = it },
        label = {
            Text(
                text = hint
            )
        },
        visualTransformation = if (passwordMode) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            if (type == KeyboardType.Password) {
                val image =
                    if (passwordMode) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val desc = if (passwordMode) "Hide Password" else "Show Password"
                IconButton(onClick = { passwordMode = !passwordMode }) {
                    Icon(imageVector = image, contentDescription = desc)

                }
            }
        },
        singleLine = true,
        modifier = modifier
            .padding(all = 16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            capitalization = capitalization, autoCorrect = true, keyboardType = type
        ),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            containerColor = color
        )
    )
}

@Preview
@Composable
fun PreviewWidget() {
    Column() {
        InputTextField(
            modifier = Modifier,
            hint = "Enter Username",
            type = KeyboardType.Text,
            capitalization = KeyboardCapitalization.None, color = White
        )
        InputTextField(
            modifier = Modifier,
            hint = "Password",
            type = KeyboardType.Password,
            capitalization = KeyboardCapitalization.None, color = White
        )
    }
}

