package com.veroanggra.migratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.ViewCompat.FocusDirection
import com.veroanggra.composesubmission.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithComposeTheme {
                Surface {
                    PredicateScreen()
                }
            }
        }
    }

    @Composable
    fun PredicateScreen(modifier: Modifier = Modifier) {
        var name by remember {
            mutableStateOf("")
        }

        var score by remember {
            mutableStateOf("")
        }

        val validName = remember(name) {
            name.isNotEmpty()
        }

        val validScore = remember(score) {
            score.isNotEmpty()
        }

        var showPredicate by remember {
            mutableStateOf(false)
        }

        var showFinaleScore by remember {
            mutableStateOf(0.0)
        }

        ConstraintLayout(modifier = modifier.fillMaxSize()) {
            val (title, form, buttonRow, resultText, firstSpacer) = createRefs()
            Text(
                text = "Write Your Score and Get \nYour Predicate!",
                fontSize = 30.sp, fontWeight = FontWeight.Bold, lineHeight = 35.sp,
                modifier = modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .constrainAs(title) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    })
            ScoreForm(
                name = name,
                onNameValueChange = { name = it },
                score = score,
                onScoreValueChange = { score = it },
                modifier = modifier
                    .padding(top = 20.dp)
                    .constrainAs(form) {
                        top.linkTo(title.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
            Row(
                modifier = modifier
                    .constrainAs(buttonRow) {
                        top.linkTo(form.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        if (!validName || !validScore) return@Button
                        showPredicate = true
                        showFinaleScore = score.toDouble()
                    },
                    modifier = modifier
                        .width(150.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        Pink80
                    )
                ) {
                    Text(text = "Check")
                }

                Button(
                    onClick = {
                        name = ""
                        score = ""
                        showPredicate = false
                    },
                    modifier = modifier
                        .width(150.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        Pink80
                    )
                ) {
                    Text(text = "Reset")
                }
            }
            Spacer(modifier = modifier
                .height(10.dp)
                .constrainAs(firstSpacer) {
                    top.linkTo(buttonRow.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            if (showPredicate) {
                val getPredicate = getPredicateStatus(showFinaleScore)
                Text(
                    text = "Halo $name, \n\nYour Predicate for this semester ${getPredicate.predicate}",
                    fontSize = 18.sp,
                    modifier = modifier
                        .padding(start = 40.dp, end = 40.dp)
                        .constrainAs(resultText) {
                            top.linkTo(firstSpacer.bottom)
                            start.linkTo(parent.start)
                        })
            }
        }
    }

    @Composable
    fun ScoreForm(
        modifier: Modifier,
        name: String,
        onNameValueChange: (String) -> Unit,
        score: String,
        onScoreValueChange: (String) -> Unit
    ) {
        val focusManager = LocalFocusManager.current
        Column(
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            InputTextField(
                action = ImeAction.Next,
                label = "Type Your Name",
                value = name,
                onValueChanged = onNameValueChange,
                keyboardType = KeyboardType.Text,
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Down) })
            )
            InputTextField(
                action = ImeAction.Done,
                label = "Type Your Score",
                value = score,
                onValueChanged = onScoreValueChange,
                keyboardType = KeyboardType.Number,
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
            )
        }
    }

    @Composable
    fun InputTextField(
        modifier: Modifier = Modifier,
        action: ImeAction,
        label: String,
        value: String,
        onValueChanged: (String) -> Unit,
        keyboardType: KeyboardType,
        keyboardActions: KeyboardActions
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            label = { Text(text = label) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = YellowD8AC4E,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = YellowD8AC4E,
                unfocusedLabelColor = Color.Gray
            ),
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = action
            ), modifier = modifier
                .padding(start = 20.dp, end = 20.dp, top = 5.dp)
                .fillMaxWidth()
                .height(80.dp)
        )
    }
}