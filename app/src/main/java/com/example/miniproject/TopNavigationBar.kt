package com.example.miniproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopNavigationBar() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.profile), contentDescription = "",
            Modifier
                .size(40.dp)
                .border(border = BorderStroke(width = 2.dp, Color.White), shape = CircleShape)
                .clip(shape = CircleShape), contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(start = 5.dp, top = 5.dp)) {
            Text("Hello , Sreyka", fontSize = 15.sp, color = Color.White)
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "view profile", fontSize = 12.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            Modifier
                .size(50.dp)
                .padding(top = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "",
                Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.padding(start = 8.dp))
            Image(painter = painterResource(id = R.drawable.ic_bk), contentDescription = "",
                Modifier
                    .clickable { showDialog = true })

        }
    }
    if (showDialog)
        ShowAlertDialog(showDialog) {
            showDialog = false
        }

}


fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}
