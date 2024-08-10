package com.mrgelatine.gemlense.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(name = "UserPledge", showBackground = true)
fun UserPledge(userName: String = "Andry Wilson"){
    Row(){
        GlideImage(
            model = "https://example.com/image.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = placeholder()
        )
        Column(){
            Text(
                text = "Welcome back \uD83D\uDC4B",
                modifier = Modifier.align(alignment = Alignment.Start)
            )
            Text(
                text = userName,
                modifier = Modifier.align(alignment = Alignment.Start)
            )
        }
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "PRO")
        }
    }
}
