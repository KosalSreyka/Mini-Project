package com.example.miniproject

import android.util.Log
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true, widthDp = 200, heightDp = 200)
@Composable
fun CardBalance() {
    var showBalance by remember {
        mutableStateOf(true)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(
                border = BorderStroke(2.dp, getGradient(Color(0xFFD027B5), Color(0xFF673AB7))),
                shape = RoundedCornerShape(10.dp)
            )

    )
    {
        Column(Modifier.padding(10.dp)) {
            Row(Modifier.fillMaxWidth()) {
                if (showBalance) {
                    Text("100000.00$", Modifier.padding(top = 5.dp), color = Color.White)
                } else {
                    Text(
                        text = "100000.00$",
                        Modifier
                            .padding(top = 5.dp)
                            .border(
                                BorderStroke(20.dp, Color.LightGray),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .background(Color.Gray.copy(alpha = 0.5f)), // Semi-transparent background
                        color = Color.Transparent,


                        )
                    //}

                }


                Spacer(modifier = Modifier.padding(start = 10.dp))
                Icon(painter = painterResource(id = R.drawable.eye), contentDescription = "",
                    Modifier
                        .padding(top = 0.dp)
                        .clickable { showBalance = !showBalance }, tint = Color.White
                )
            }
            Row {
                SuggestionChip(
                    onClick = { Log.d("Suggestion chip", "hello world") },
                    label = { Text("Default") },
                    colors = SuggestionChipDefaults.suggestionChipColors(
                        containerColor = Color(0xFF34C2FF) // Set your desired background color here
                        , labelColor = Color.White
                    )
                )
                Text("Saving", Modifier.padding(start = 5.dp, top = 15.dp), color = Color.White)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_receive),
                    contentDescription = "",
                    Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.padding(start = 5.dp))
                Text(
                    text = "Receive money",
                    Modifier.padding(top = 5.dp),
                    fontSize = 12.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_pay),
                    contentDescription = "",
                    Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.padding(start = 2.dp))
                Text(
                    text = "Send money",
                    Modifier.padding(top = 5.dp),
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
    }

}
