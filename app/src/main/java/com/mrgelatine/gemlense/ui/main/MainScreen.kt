package com.mrgelatine.gemlense.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.shimmer.Shimmer
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
@Preview(name = "UserPledge", showBackground = true)
fun UserPledge(userName: String = "Andrew Ainsley", modifier:Modifier = Modifier
    .height(75.dp)
    .fillMaxWidth()){
    val localDensity = LocalDensity.current
    var heightIs by remember {
        mutableStateOf(0.dp)
    }
    Row(
        modifier = modifier
            .onGloballyPositioned {
                coordinates -> heightIs = with(localDensity) { coordinates.size.height.toDp() }
            },
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Row{
            GlideImage(
                imageModel = {"https://i.pinimg.com/originals/ab/ae/35/abae35cbd5287041fa774fcfbae5b308.png"},
                component = rememberImageComponent {
                    + ShimmerPlugin(
                        Shimmer.Flash(
                            baseColor = Color.White,
                            highlightColor = Color.LightGray,
                        ),
                    )
                },
                imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                modifier = Modifier
                    .padding(5.dp)
                    .width(heightIs - 5.dp)
                    .fillMaxHeight()
                    .clip(CircleShape),
            )
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(5.dp)
                    .fillMaxHeight()
            ){
                Text(
                    text = "Welcome back \uD83D\uDC4B",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .padding(5.dp)
                )
                Text(
                    text = userName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(alignment = Alignment.BottomStart)
                        .padding(5.dp)
                )
            }
        }
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .wrapContentSize()
        ) {
            Icon(
                Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = "PRO",
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}
