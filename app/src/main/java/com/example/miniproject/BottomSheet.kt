package com.example.miniproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val image = listOf(
    R.drawable.myui,
    R.drawable.img,
    R.drawable.myui,
    R.drawable.myui,

    )

data class app(val label: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetComponent(status: Boolean, Onclose: () -> Unit) {
    if (status) {
        ModalBottomSheet(onDismissRequest = { Onclose() }) {
            ShowBottomSheet(Onclose)
        }
    }

}


@Composable
fun ShowBottomSheet(Onclose: () -> Unit) {
    var selected by remember {
        mutableStateOf("Themes")
    }
    var enable by remember {
        mutableStateOf(true)
    }
    var label = listOf(
        "Themes",
        "Dark Mode",
        "Language"

    )
    Column(Modifier.padding(10.dp)) {
        Text("Appearance", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp))
        {
            label.forEachIndexed { index, item ->
                FilterChip(
                    selected = selected == item,
                    onClick = {
                        enable = true
                        selected = item
                    },
                    label = { Text(text = item) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = if (enable)
                            Color.Transparent else Color(0xFFCBE5FF)
                    ),
                    enabled = enable,
                    border = BorderStroke(0.dp, Color.LightGray),


                    )

            }

        }

        if (selected == "Themes") {
            Column(Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(10.dp))
                Themes()

                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = { Onclose() }) {
                        Text(text = "Save")
                    }
                }


            }

        } else if (selected == "Dark Mode") {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("This is Dark Mode", textAlign = TextAlign.Center, fontSize = 20.sp)
            }

        } else if (selected == "Language") {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("This is Language", textAlign = TextAlign.Center, fontSize = 20.sp)
            }
        }


    }


}

@Composable
fun Themes() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp) // Ensure no extra spacing
    ) {

        for (img in image) {
            Box(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = "",
                    modifier = Modifier
                        .width(90.dp)
                        .height(150.dp)
                        .border(
                            border = BorderStroke(10.dp, Color.White),
                            shape = RoundedCornerShape(10.dp)
                        )
                )
            }
        }
    }
}