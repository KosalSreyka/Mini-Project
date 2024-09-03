package com.example.miniproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.miniproject.ui.theme.MiniProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var image = listOf(
            R.drawable.slide1,
            R.drawable.slide2,
            R.drawable.slide3,
            R.drawable.slide4
        )
        var bgColor = Color(0xFF00468B)
        setContent {

            SetBarColor(color = bgColor)

            LazyColumn(
                Modifier
                    .fillMaxHeight()
                    .background(bgColor)
            ) {

                // top bar of screen
                item {
                    TopNavigationBar()
                }
                // balance
                item { CardBalance() }

                // card
                item { CardComponent() }

                // slider
                item { SlideShow(image) }

                // button
                item { ButtomComponent() }

            }

        }

    }
}

@Composable
fun ButtomComponent() {
    var show by remember {
        mutableStateOf(false)
    }
    var close by remember {
        mutableStateOf(false)
    }
    Button(
        onClick = {
            show = true
            close = true
        }, colors = buttonColors(
            contentColor = Color.Blue,
            containerColor = Color.White
        ), modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text("Edit home")
    }
    if (show)
        BottomSheetComponent(status = show)
        {
            show = false
        }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiniProjectTheme {
        Greeting("Android")
    }
}