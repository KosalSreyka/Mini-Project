package com.example.miniproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miniproject.model.CardInfo


var listOfCard = listOf(
    CardInfo("Account", "Your balance", icon = R.drawable.ic_acc),
    CardInfo("Pay bills", "School ,Shop,etc", R.drawable.ic_bills),
    CardInfo("Transfer", "Send money", R.drawable.ic_transfer),
    CardInfo("Favorite", "Users", R.drawable.ic_fav),
    CardInfo("Scan", "Scan and pay", R.drawable.ic_scan),
    CardInfo("Service", "Your balance", R.drawable.ic_service)

)

@Preview
@Composable
fun CardComponent() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(10.dp))
            .padding(10.dp)
            .border(
                border = BorderStroke(
                    2.dp,
                    getGradient(Color(0xFFD027B5), Color(0xFF673AB7))
                ), shape = RoundedCornerShape(10.dp)
            )

    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
            //  , modifier = Modifier.fillMaxHeight(),
            ,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            userScrollEnabled = false
        ) {
            items(listOfCard.size)
            {
                CardItem(it)
            }

        }
    }

}

@Composable
fun CardItem(index: Int) {
    val listIndex = listOfCard[index]
    var paddingLast = 0.dp
    if (index == listOfCard.size - 1)
        paddingLast = 10.dp

    Column(
        Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .size(117.dp, 75.dp)
            .padding(10.dp),
    ) {

        Row {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Image(
                painter = painterResource(id = listIndex.icon),
                contentDescription = "",
                Modifier.size(30.dp)
            )
        }

        Text(text = listIndex.title)
        Text(text = listIndex.detail, fontSize = 10.sp)


    }
}
