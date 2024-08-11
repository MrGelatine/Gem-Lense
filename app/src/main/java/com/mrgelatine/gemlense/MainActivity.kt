package com.mrgelatine.gemlense

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.Glide
import com.mrgelatine.gemlense.ui.main.InstrumentInfo
import com.mrgelatine.gemlense.ui.main.MainScreen
import com.mrgelatine.gemlense.ui.theme.GemLenseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        setContent {
            GemLenseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(instruments = instruments)
                }
            }
        }
    }
}


