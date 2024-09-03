package com.example.miniproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun ShowAlertDialog(status: Boolean, OnClose: () -> Unit) {
    if (status) {
        Dialog(
            onDismissRequest = { OnClose() },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.qrbg),
                    contentDescription = "QR Background",
                    modifier = Modifier
                        .size(400.dp)
                        .align(Alignment.Center)
                )
                Text(
                    "Kosal Sreyka", fontSize = 20.sp, modifier = Modifier
                        .size(400.dp)
                        .align(Alignment.Center)
                        .padding(start = 90.dp, top = 70.dp)
                )
                Text(
                    "0$", fontSize = 26.sp, fontWeight = FontWeight.Medium, modifier = Modifier
                        .size(400.dp)
                        .align(Alignment.Center)
                        .padding(start = 90.dp, top = 100.dp)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.Center) // Center the QR code
                        .padding(top = 100.dp) // Add top padding
                ) {
                    QrCodeDisplay(
                        "https://pay.ababank.com/r4LUHz6Nn76t3yT18",
                        modifier = Modifier.size(200.dp) // Adjust size
                    )
                }

                IconButton(
                    onClick = {
                        OnClose()

                    },
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.TopEnd)
                        .padding(6.dp),
                    colors = IconButtonDefaults.iconButtonColors(Color.Gray)
                ) {
                    Icon(
                        Icons.Default.Close, // Replace with your close icon
                        contentDescription = "Close",
                        Modifier.size(25.dp),
                        tint = Color.White
                    )
                }
            }
        }


    }

}


