package com.veroanggra.migratingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.veroanggra.composesubmission.ui.theme.GreenDarkBackground
import com.veroanggra.composesubmission.ui.theme.GreenLightBackground
import com.veroanggra.composesubmission.ui.theme.OrangePickerColor
import com.veroanggra.composesubmission.ui.theme.PlayingWithComposeTheme
import com.veroanggra.migratingsample.widget.CircleBackground
import com.veroanggra.migratingsample.widget.ImageCircle
import com.veroanggra.migratingsample.widget.ImageRounded

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
        val guidelineLeft = createGuidelineFromAbsoluteLeft(.55f)
        val guidelineBottom = createGuidelineFromTop(.20f)
        val guidelineTop = createGuidelineFromTop(.11f)
        val (circleFirst, circleSecond, whiteBackground, topLine, drawerIcon, title, bottomLine, firstSpacer, firstImage, secondImage, thirdImage, itemFirstTitle, itemFirstDesc, itemSecondTitle, itemSecondDesc, itemThirdTitle) = createRefs()
        val (itemThirdDesc, authorTitle, firstAuthorImage, firstAuthorName, secondAuthorImage, secondAuthorName, thirdAuthorImage, thirdAuthorName) = createRefs()
        createHorizontalChain(
            firstAuthorImage,
            secondAuthorImage,
            thirdAuthorImage,
            chainStyle = ChainStyle.SpreadInside
        )

        CircleBackground(modifier = modifier.constrainAs(circleFirst) {
            bottom.linkTo(guidelineBottom)
            end.linkTo(guidelineLeft)
        }, colors = GreenDarkBackground, size = 300)

        CircleBackground(
            modifier = modifier
                .padding(end = 90.dp, bottom = 40.dp)
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
                .height(570.dp)
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
                .width(60.dp)
                .height(5.dp)
                .constrainAs(topLine) {
                    top.linkTo(guidelineTop)
                    start.linkTo(whiteBackground.start)
                    end.linkTo(whiteBackground.end)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.drawer),
            contentDescription = null,
            modifier
                .padding(start = 20.dp, top = 30.dp)
                .constrainAs(drawerIcon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })
        Text(
            text = "Handpicked",
            fontSize = 20.sp,
            modifier = modifier
                .padding(top = 30.dp)
                .constrainAs(title) {
                    top.linkTo(whiteBackground.top)
                    start.linkTo(whiteBackground.start)
                    end.linkTo(whiteBackground.end)
                })
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(5))
                .background(color = Color.Transparent)
                .width(40.dp)
                .height(20.dp)
                .constrainAs(firstSpacer) {
                    top.linkTo(title.bottom)
                    start.linkTo(title.start)
                    end.linkTo(title.end)
                }
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(5))
                .background(color = OrangePickerColor)
                .width(40.dp)
                .height(5.dp)
                .constrainAs(bottomLine) {
                    top.linkTo(firstSpacer.bottom)
                    start.linkTo(firstSpacer.start)
                    end.linkTo(firstSpacer.end)
                }
        )
        ImageRounded(
            modifier = modifier
                .padding(start = 20.dp, top = 20.dp)
                .constrainAs(firstImage) {
                    top.linkTo(bottomLine.bottom)
                    start.linkTo(parent.start)
                }, image = R.drawable.pict1
        )
        ImageRounded(
            modifier = modifier
                .padding(start = 20.dp, top = 15.dp)
                .constrainAs(secondImage) {
                    top.linkTo(firstImage.bottom)
                    start.linkTo(parent.start)
                }, image = R.drawable.pict2
        )
        ImageRounded(
            modifier = modifier
                .padding(start = 20.dp, top = 15.dp)
                .constrainAs(thirdImage) {
                    top.linkTo(secondImage.bottom)
                    start.linkTo(parent.start)
                }, image = R.drawable.pict3
        )
        Text(
            text = "Financial Freedom",
            fontSize = 18.sp, textAlign = TextAlign.Left,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp, top = 30.dp)
                .constrainAs(itemFirstTitle) {
                    start.linkTo(firstImage.end)
                    top.linkTo(firstImage.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = "Natasha Rose",
            fontSize = 14.sp, textAlign = TextAlign.Left,
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                .constrainAs(itemFirstDesc) {
                    start.linkTo(itemFirstTitle.start)
                    top.linkTo(itemFirstTitle.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = "Minimalism Lifestyle",
            fontSize = 18.sp, textAlign = TextAlign.Left,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp, top = 30.dp)
                .constrainAs(itemSecondTitle) {
                    start.linkTo(secondImage.end)
                    top.linkTo(secondImage.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = "Jane Rose",
            fontSize = 14.sp, textAlign = TextAlign.Left,
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                .constrainAs(itemSecondDesc) {
                    start.linkTo(itemSecondTitle.start)
                    top.linkTo(itemSecondTitle.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = "Bisnis Strategy",
            fontSize = 18.sp, textAlign = TextAlign.Left,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp, top = 30.dp)
                .constrainAs(itemThirdTitle) {
                    start.linkTo(thirdImage.end)
                    top.linkTo(thirdImage.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = "Ronald Godez",
            fontSize = 14.sp, textAlign = TextAlign.Left,
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                .constrainAs(itemThirdDesc) {
                    start.linkTo(itemThirdTitle.start)
                    top.linkTo(itemThirdTitle.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = "Top Author",
            fontSize = 20.sp,
            textAlign = TextAlign.Left,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp, top = 30.dp)
                .constrainAs(authorTitle) {
                    start.linkTo(parent.start)
                    top.linkTo(thirdImage.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        ImageCircle(
            modifier = modifier
                .padding(start = 40.dp, top = 20.dp)
                .constrainAs(firstAuthorImage) {
                    start.linkTo(authorTitle.start)
                    top.linkTo(authorTitle.bottom)
                }, image = R.drawable.pict1
        )
        Text(
            text = "Jane Rose", fontSize = 12.sp,
            modifier = modifier
                .padding(top = 10.dp, start = 40.dp)
                .constrainAs(firstAuthorName) {
                    top.linkTo(firstAuthorImage.bottom)
                    start.linkTo(firstAuthorImage.start)
                    end.linkTo(firstAuthorImage.end)
                })
        ImageCircle(
            modifier = modifier
                .padding(top = 20.dp)
                .constrainAs(secondAuthorImage) {
                    top.linkTo(firstAuthorImage.top)
                    bottom.linkTo(firstAuthorImage.bottom)
                }, image = R.drawable.pict1
        )
        Text(
            text = "Robert Dun", fontSize = 12.sp,
            modifier = modifier
                .padding(top = 10.dp)
                .constrainAs(secondAuthorName) {
                    top.linkTo(secondAuthorImage.bottom)
                    start.linkTo(secondAuthorImage.start)
                    end.linkTo(secondAuthorImage.end)
                })
        ImageCircle(
            modifier = modifier
                .padding(end = 40.dp, top = 20.dp)
                .constrainAs(thirdAuthorImage) {
                    top.linkTo(secondAuthorImage.top)
                    bottom.linkTo(secondAuthorImage.bottom)
                    end.linkTo(authorTitle.end)
                }, image = R.drawable.pict1
        )
        Text(
            text = "Anastacia", fontSize = 12.sp,
            modifier = modifier
                .padding(top = 10.dp, end = 40.dp)
                .constrainAs(thirdAuthorName) {
                    top.linkTo(thirdAuthorImage.bottom)
                    start.linkTo(thirdAuthorImage.start)
                    end.linkTo(thirdAuthorImage.end)
                })
    }
}

