package com.example.stocldetais

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stocldetais.bottombar.Graph
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StockData() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                text = "Stock Details", fontSize = 22.sp, fontWeight = FontWeight.Bold
            )
        }, navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        }, actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = "Localized description"
                )
            }
        },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.White)
        )
    })
    {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            StockInfo()

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
            )
            {
                val time = listOf(
                    ButtonItem("1D", true),
                    ButtonItem("1W", false),
                    ButtonItem("1M", false),
                    ButtonItem("1Y", false),
                    ButtonItem("All", false)
                )
                for (i in time) {
                    Button(
                        onClick = {
                            i.isClicked = true
                        },
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Color.Gray),
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                        colors = if (i.isClicked) ButtonDefaults.buttonColors(Color(0xFF009688)) else ButtonDefaults.buttonColors(
                            Color.White
                        )
                    ) {
                        if (i.isClicked)
                            Text(text = i.text, modifier = Modifier.padding(4.dp))
                        else
                            Text(
                                text = i.text,
                                modifier = Modifier.padding(4.dp),
                                color = Color.DarkGray
                            )

                    }
                }
            }

            val yStep = 50
            val random = Random
            /* to test with random points */
            val points = (0..9).map {
                var num = random.nextInt(350)
                if (num <= 50)
                    num += 100
                num.toFloat()
            }

            Graph(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
                    .height(180.dp),
                xValues = (0..9).map { it + 1 },
                yValues = (0..6).map { (it + 1) * yStep },
                points = points,
                paddingSpace = 16.dp,
                verticalStep = yStep,
                lineColor = Color.Gray,
                true
            )

            Card(
                border = BorderStroke(1.dp, color = Color.LightGray),
                elevation = CardDefaults.cardElevation(0.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = Color.White)
                    .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
            )
            {

                Column {
                    Row(modifier = Modifier.padding(top = 15.dp, start = 10.dp, end = 10.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_nvidia),
                            contentDescription = "",
                            tint = Color(0xFF009688),
                            modifier = Modifier
                        )
                        Text(
                            text = "OverView",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = Color(0xFF009688),
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_help),
                                contentDescription = "",
                                tint = Color(0xFF009688),
                                modifier = Modifier.align(Alignment.End)
                            )
                        }

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(8.dp)
                        ) {

                            Text(
                                text = "Open",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = "$ 99.152",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color(0xFF042B27)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(8.dp)
                        ) {

                            Text(
                                text = "Day low",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = "$15.26",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color(0xFF042B27)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .align(Alignment.CenterVertically)
                                .padding(8.dp)
                        ) {

                            Text(
                                text = "Day high",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(end = 10.dp),
                                color = Color.Gray
                            )
                            Text(
                                text = "$23.14",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(end = 10.dp),
                                color = Color(0xFF042B27)
                            )
                        }
                    }
                }

            }

            Row(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {

                Button(
                    onClick = {}, modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 10.dp)
                        .height(50.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF009688))
                ) {

                    Text(text = "Buy", color = Color.White)
                }

                Button(
                    onClick = {}, modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 20.dp)
                        .height(50.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF042B27))
                ) {

                    Text(text = "Follow", color = Color.White)
                }

            }

        }

    }
}

@Composable
fun StockInfo() {
    Card(
        border = BorderStroke(1.dp, color = Color.LightGray),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color.White)
            .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
    )
    {
        Row(modifier = Modifier.fillMaxWidth()) {

            Icon(
                painter = painterResource(id = R.drawable.ic_nvidia),
                contentDescription = "",
                tint = Color(0xFF009688),
                modifier = Modifier
                    .align(
                        Alignment.CenterVertically
                    )
                    .size(50.dp)
                    .padding(10.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(8.dp)
            ) {

                Text(
                    text = "NVidia",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "NVDE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .padding(8.dp)
            ) {

                Text(
                    text = "$ 25.949",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 10.dp),
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "↑10.15%(+1.79%)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 10.dp),
                    color = Color(0xFF009688)
                )
            }
        }
    }
}

data class ButtonItem(val text: String, var isClicked: Boolean)