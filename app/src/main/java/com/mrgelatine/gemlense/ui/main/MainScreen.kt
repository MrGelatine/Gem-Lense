package com.mrgelatine.gemlense.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned

import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.shimmer.Shimmer
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun UserPledge(userName: String, userAvatar: String, modifier:Modifier ){
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
        GlideImage(
            imageModel = {userAvatar},
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
                .height(heightIs - 5.dp)
                .clip(CircleShape),
        )
        Box(
            modifier = Modifier
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
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
            modifier = Modifier
                .wrapContentSize()
                .align(alignment = Alignment.CenterVertically)
        ) {
            Icon(
                Icons.Default.Star,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = "PRO",
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}
@Composable
@Preview(name = "UserPledge", showBackground = true)
fun UserPledgePreview(){
    UserPledge(
        userName = "Andrew Ainsley",
        userAvatar = "https://i.pinimg.com/originals/ab/ae/35/abae35cbd5287041fa774fcfbae5b308.png",
        modifier = Modifier.height(75.dp)
    )
}

@Composable
fun EditorPledge(){
    val colorStops = arrayOf(
        0.1f to Color.Magenta,
        1.0f to Color.White,
    )
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(colorStops = colorStops)
            ),
    ){
        Text(
            text = "Edit Photo",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(alignment = Alignment.Start)
                .padding(15.dp)
        )
        Text(
            text = "Unleash your creativity with AI multi editing toolbox!",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .align(alignment = Alignment.Start)
                .padding(15.dp)
        )
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .padding(15.dp)
        ){
            Text(
                text= "Select Photo",
                color = Color.Magenta
            )
        }
    }
}
@Composable
@Preview(name = "EditorPledge", showBackground = true)
fun EditorPledgePreview(){
    EditorPledge()
}

@Composable
fun InstrumentPledge(instrumentInfo: InstrumentInfo){
    Box(
        modifier = Modifier
        .padding(10.dp)
        .aspectRatio(1.0f))
    {
        GlideImage(
            imageModel = {instrumentInfo.instrumentBackground},
            component = rememberImageComponent {
                + ShimmerPlugin(
                    Shimmer.Flash(
                        baseColor = Color.White,
                        highlightColor = Color.LightGray,
                    ),
                )
            },
            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
            requestOptions = {
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
            },
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
        )
        Text(
            text = instrumentInfo.instrumentInfo,
            fontSize = 20.sp,
            color = Color.White,
            modifier= Modifier
                .align(alignment = Alignment.BottomStart)
                .padding(10.dp)
        )
    }


}
@Composable
@Preview(name = "InstrumentPledge", showBackground = true)
fun InstrumentPledgesPreview(){
    InstrumentPledge(
        InstrumentInfo(
            instrumentInfo = "Background Remove AI",
            instrumentBackground = "https://petapixel.com/assets/uploads/2022/05/remove-background-in-photoshop.jpg"
        )
    )
}

@Composable
fun MainScreen(instruments: List<InstrumentInfo>){
    val localDensity = LocalDensity.current
    var heightIs by remember {
        mutableStateOf(0.dp)
    }
    Column(
        modifier = Modifier
            .padding(10.dp)
            .onGloballyPositioned {
                coordinates -> heightIs = with(localDensity) { coordinates.size.width.toDp() }
    }
    ){
        UserPledge(
            userName = "Andrew Ainsley",
            userAvatar = "https://i.pinimg.com/originals/ab/ae/35/abae35cbd5287041fa774fcfbae5b308.png",
            modifier = Modifier.height(75.dp)
        )
        EditorPledge()
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2)
        ){
            items(instruments) {instrument ->
                InstrumentPledge(instrument)
            }
        }

    }

}
@Composable
@Preview(name = "MainScreenPreview", showBackground = true)
fun MainScreenPreview(){
    val instruments = listOf(
        InstrumentInfo(
            instrumentInfo = "Background Remove AI",
            instrumentBackground = "https://petapixel.com/assets/uploads/2022/05/remove-background-in-photoshop.jpg"
        ),
        InstrumentInfo(
            instrumentInfo = "Background Remove AI",
            instrumentBackground = "https://petapixel.com/assets/uploads/2022/05/remove-background-in-photoshop.jpg"
        ),
        InstrumentInfo(
            instrumentInfo = "Background Remove AI",
            instrumentBackground = "https://petapixel.com/assets/uploads/2022/05/remove-background-in-photoshop.jpg"
        ),
        InstrumentInfo(
            instrumentInfo = "Background Remove AI",
            instrumentBackground = "https://petapixel.com/assets/uploads/2022/05/remove-background-in-photoshop.jpg"
        ),
        InstrumentInfo(
            instrumentInfo = "Background Remove AI",
            instrumentBackground = "https://petapixel.com/assets/uploads/2022/05/remove-background-in-photoshop.jpg"
        ),

    )
    MainScreen(instruments)
}
