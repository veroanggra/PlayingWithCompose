package com.veroanggra.migratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.veroanggra.composesubmission.ui.theme.PlayingWithComposeTheme
import com.veroanggra.composesubmission.ui.theme.blueA9CADA
import com.veroanggra.composesubmission.ui.theme.blueDFEDF3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithComposeTheme {
                Surface {
                    GaleryApp()
                }
            }
        }
    }

    @Composable
    fun GaleryApp(modifier: Modifier = Modifier) {
        var feelCode by remember {
            mutableStateOf(0)
        }
        var isExpanded by remember { mutableStateOf(true) }
        // declare
        val animateList by animateDpAsState(
            targetValue = if (isExpanded) 300.dp else 250.dp, animationSpec = spring(
                Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessLow
            )
        )

        ConstraintLayout(
            modifier
                .fillMaxSize()
                .background(color = blueA9CADA)
        ) {
            val (emoticonImage, questionText, sadButton, boredButton, pressureButton, firstSpacer, happyButton, laughingButton, loveButton, textSuggest, textAsk) = createRefs()
            createHorizontalChain(
                sadButton,
                boredButton,
                pressureButton,
                chainStyle = ChainStyle.Packed
            )
            createHorizontalChain(
                happyButton,
                laughingButton, loveButton,
                chainStyle = ChainStyle.Packed
            )
            when (feelCode) {
                1 -> {
                    ImageTop(
                        image = R.drawable.sad,
                        modifier = modifier
                            .size(animateList)
                            .constrainAs(emoticonImage) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            })
                    TextSuggest(
                        text = stringResource(R.string.sad_quotes),
                        modifier = modifier.constrainAs(textSuggest) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(emoticonImage.bottom)
                        })
                }
                2 -> {
                    ImageTop(
                        image = R.drawable.bored,
                        modifier = modifier
                            .size(animateList)
                            .constrainAs(emoticonImage) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            })
                    TextSuggest(
                        text = stringResource(R.string.bored_quotes),
                        modifier = modifier.constrainAs(textSuggest) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(emoticonImage.bottom)
                        })
                }
                3 -> {
                    ImageTop(
                        image = R.drawable.pressure,
                        modifier = modifier
                            .size(animateList)
                            .constrainAs(emoticonImage) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            })
                    TextSuggest(
                        text = stringResource(R.string.pressure_quotes),
                        modifier = modifier.constrainAs(textSuggest) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(emoticonImage.bottom)
                        })
                }
                4 -> {
                    ImageTop(
                        image = R.drawable.happy,
                        modifier = modifier
                            .size(animateList)
                            .constrainAs(emoticonImage) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            })
                    TextSuggest(
                        text = stringResource(R.string.happy_quotes),
                        modifier = modifier.constrainAs(textSuggest) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(emoticonImage.bottom)
                        })
                }
                5 -> {
                    ImageTop(
                        image = R.drawable.laughing,
                        modifier = modifier
                            .size(animateList)
                            .constrainAs(emoticonImage) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            })
                    TextSuggest(
                        text = stringResource(R.string.laughing_quotes),
                        modifier = modifier.constrainAs(textSuggest) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(emoticonImage.bottom)
                        })
                }
                6 -> {
                    ImageTop(
                        image = R.drawable.love,
                        modifier = modifier
                            .size(animateList)
                            .constrainAs(emoticonImage) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            })
                    TextSuggest(
                        text = stringResource(R.string.love_quotes),
                        modifier = modifier.constrainAs(textSuggest) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(emoticonImage.bottom)
                        })
                }
                else -> ImageTop(
                    image = R.drawable.surprised,
                    modifier = modifier
                        .size(animateList)
                        .constrainAs(emoticonImage) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                        })
            }
            if (isExpanded) {
                Text(
                    text = "What do you feel today ?",
                    fontSize = 16.sp,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, top = 20.dp, end = 20.dp)
                        .constrainAs(questionText) {
                            start.linkTo(parent.start)
                            top.linkTo(emoticonImage.bottom)
                            end.linkTo(parent.end)
                        })
                ImageButton(image = R.drawable.sad, modifier = modifier.constrainAs(sadButton) {
                    start.linkTo(parent.start)
                    top.linkTo(firstSpacer.bottom)
                }, onClick = {
                    feelCode = 1
                    isExpanded = false
                })
                ImageButton(image = R.drawable.bored, modifier = modifier.constrainAs(boredButton) {
                    start.linkTo(sadButton.end)
                    top.linkTo(sadButton.top)
                    bottom.linkTo(sadButton.bottom)
                }, onClick = {
                    feelCode = 2
                    isExpanded = false
                })
                ImageButton(
                    image = R.drawable.pressure,
                    modifier = modifier.constrainAs(pressureButton) {
                        start.linkTo(boredButton.end)
                        top.linkTo(boredButton.top)
                        bottom.linkTo(boredButton.bottom)
                        end.linkTo(parent.end)
                    }, onClick = {
                        feelCode = 3
                        isExpanded = false
                    })
                ImageButton(image = R.drawable.happy, modifier = modifier.constrainAs(happyButton) {
                    start.linkTo(parent.start)
                    top.linkTo(sadButton.bottom)
                }, onClick = {
                    feelCode = 4
                    isExpanded = false
                })
                ImageButton(
                    image = R.drawable.laughing,
                    modifier = modifier.constrainAs(laughingButton) {
                        start.linkTo(happyButton.end)
                        top.linkTo(happyButton.top)
                        bottom.linkTo(happyButton.bottom)
                    }, onClick = {
                        feelCode = 5
                        isExpanded = false
                    })
                ImageButton(
                    image = R.drawable.love,
                    modifier = modifier.constrainAs(loveButton) {
                        start.linkTo(laughingButton.end)
                        top.linkTo(laughingButton.top)
                        bottom.linkTo(laughingButton.bottom)
                        end.linkTo(parent.end)
                    }, onClick = {
                        feelCode = 6
                        isExpanded = false
                    })

            } else {
                Text(text = "Click Here for Asking Again!", fontSize = 12.sp, modifier = modifier
                    .clickable {
                        isExpanded = true
                        feelCode = 0
                    }
                    .padding(start = 40.dp, end = 40.dp, top = 20.dp)
                    .constrainAs(textAsk) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(textSuggest.bottom)
                    })
            }
            Spacer(modifier = modifier
                .height(20.dp)
                .constrainAs(firstSpacer) {
                    if (isExpanded) {
                        top.linkTo(questionText.bottom)
                    } else {
                        top.linkTo(textAsk.bottom)
                    }
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        }
    }

    @Composable
    fun ImageTop(modifier: Modifier = Modifier, image: Int) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier
                .padding(top = 20.dp)
        )
    }

    @Composable
    fun ImageButton(modifier: Modifier = Modifier, image: Int, onClick: () -> Unit) {
        Image(
            painter = painterResource(image),
            modifier = modifier
                .size(100.dp)
                .padding(10.dp)
                .clickable { onClick() },
            contentDescription = null
        )
    }

    @Composable
    fun TextSuggest(modifier: Modifier = Modifier, text: String) {
        Box(
            modifier
                .width(300.dp)
                .wrapContentHeight()
                .clip(RoundedCornerShape(20))
                .background(color = blueDFEDF3)
        ) {
            Text(
                text = text,
                fontSize = 12.sp,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
        }
    }
}