package com.example.stocldetais.bottombar

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import android.graphics.PointF
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stocldetais.R
import com.example.stocldetais.StockDataActivity
import com.patrykandpatrick.vico.core.entry.entryModelOf
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Alex Julia", fontSize = 22.sp, fontWeight = FontWeight.Bold
            )
        }, navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu, contentDescription = "Localized description"
                )
            }
        }, actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Search, contentDescription = "Localized description"
                )
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Localized description"
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(Color.White))
    })
    {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Box(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                    .background(
                        color = MaterialTheme.colors.onSurface,
                        shape = RoundedCornerShape(CornerSize(16.dp))
                    )
                    .fillMaxWidth()
                    .padding(it)
                    .height(180.dp)
            ) {
                Row {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            modifier = Modifier.padding(top = 12.dp, start = 12.dp),
                            text = "Portfolio Value",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Row(modifier = Modifier.padding(top = 12.dp, start = 12.dp)) {
                            Text(
                                text = "$15.000",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                            Text(
                                text = "12.00%", fontSize = 12.sp, fontWeight = FontWeight.SemiBold
                            )
                        }

                        Row(modifier = Modifier.padding(12.dp)) {
                            Button(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        0xFF009688
                                    )
                                ),
                                modifier = Modifier.wrapContentSize()

                            ) {

                                Text(text = "Deposit")

                            }
                            OutlinedButton(
                                modifier = Modifier.padding(start = 8.dp),
                                onClick = { /*TODO*/ }) {

                                Text(text = "Withdraw")

                            }
                        }

                    }
                    Column(
                        modifier = Modifier
                            .background(
                                shape = RoundedCornerShape(16.dp), color = Color.White
                            )
                            .width(60.dp)
                            .align(Alignment.Bottom)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "",
                            tint = MaterialTheme.colors.onSurface,
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "",
                            tint = MaterialTheme.colors.onSurface,
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "",
                            tint = MaterialTheme.colors.onSurface,
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "",
                            tint = MaterialTheme.colors.onSurface,
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Watch List",
                        fontSize = 15.sp,
                        color = MaterialTheme.colors.onSurface,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start,
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "See All",
                        fontSize = 15.sp,
                        color = Color(0xFF009688),
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Right
                    )
                }


            }

            val num = listOf<Int>(1, 2, 3, 4)
            LazyRow(
                modifier = Modifier.padding(
                    start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp
                )
            ) {
                items(num) { item ->
                    WatchCard()
                }
            }

            Text(
                text = "Stock Activity",
                modifier = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 10.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )

            Box(modifier = Modifier.padding(bottom = 80.dp)) {
                StockCard()
            }


        }


    }
}

@Composable
fun ClockScreen() {

}

@Composable
fun TransactionScreen() {

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CandleScreen() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                text = "Markets", fontSize = 22.sp, fontWeight = FontWeight.Bold
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
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Localized description"
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.White))
    })
    {
        val num = listOf<Int>(1, 2)

        Column {
            LazyRow(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 0.dp, bottom = 10.dp)
            ) {
                items(num) { item ->
                    if (item % 2 == 0)
                        MarketCard1(CardDefaults.cardColors(Color(0xFF042B27)), Color.White)
                    else
                        MarketCard1(CardDefaults.cardColors(Color.White), Color(0xFF042B27))
                }

                //   MarketCard2()
            }

            SearchBar()

            Text(
                text = "Market Movers",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF042B27),
                modifier = Modifier.padding(start = 15.dp, top = 5.dp, bottom = 10.dp)
            )
            LazyColumn(modifier = Modifier.padding(bottom = 80.dp)) {
                val dum = listOf(1, 2, 3, 4)
                items(dum) {
                    StockCard()
                }

            }
        }


    }
}


@Composable
fun AccountScreen() {

}

@Composable
fun WatchCard() {
    val ctx = LocalContext.current
    Card(
        elevation = CardDefaults.cardElevation(0.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .background(color = Color.White)
            .padding(4.dp)
            .clickable {
                val intent = Intent(ctx, StockDataActivity::class.java)
                ctx.startActivity(intent)
            }
    )
    {
        Column {

            Row() {

                Icon(
                    painter = painterResource(id = R.drawable.ic_nvidia),
                    contentDescription = "",
                    tint = Color(0xFF009688),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(top = 20.dp, start = 20.dp, end = 8.dp, bottom = 8.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier.padding(
                        top = 20.dp, start = 4.dp, end = 12.dp, bottom = 8.dp
                    )
                ) {
                    Text(
                        text = "ADB",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = MaterialTheme.colors.onSurface
                    )
                    Text(
                        text = "Adobe inc.",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                }
                Text(
                    text = "↑ 15.90",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                Column(modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 8.dp)) {
                    Text(
                        text = "52.32",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = MaterialTheme.colors.onSurface
                    )
                    Text(
                        text = "$ 652.48",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                }

                CubicChart(
                    modifier = Modifier
                        .height(60.dp)
                        .width(120.dp),
                    graphColor = Color.Black
                )

            }
        }
    }

}

@Composable
fun CubicChart(
    modifier: Modifier = Modifier,
    yPoints: List<Float> = listOf(
        180f, 60f, 50f, 90f, 20f, 100f
    ),
    graphColor: Color
) {

    val spacing = 100f
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {

        Canvas(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
//            drawRect(
//                color = Color.White,
//                topLeft = Offset.Zero,
//                size = Size(
//                    width = size.width,
//                    height = size.height
//                ),
//                style = Stroke()
//            )

            val spacePerHour = (size.width - spacing) / yPoints.size

            val normX = mutableListOf<Float>()
            val normY = mutableListOf<Float>()

            val strokePath = Path().apply {

                for (i in yPoints.indices) {

                    val currentX = spacing + i * spacePerHour

                    if (i == 0) {

                        moveTo(currentX, yPoints[i])
                    } else {

                        val previousX = spacing + (i - 1) * spacePerHour

                        val conX1 = (previousX + currentX) / 2f
                        val conX2 = (previousX + currentX) / 2f

                        val conY1 = yPoints[i - 1]
                        val conY2 = yPoints[i]


                        cubicTo(
                            x1 = conX1,
                            y1 = conY1,
                            x2 = conX2,
                            y2 = conY2,
                            x3 = currentX,
                            y3 = yPoints[i]
                        )
                    }

                    // Circle dot points
                    normX.add(currentX)
                    normY.add(yPoints[i])

                }
            }

            /** filling the area under the path */
            drawPath(
                path = strokePath,
                color = graphColor,
                style = Stroke(
                    width = 3.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )

            (normX.indices).forEach {
                drawCircle(
                    Color.DarkGray,
                    radius = 2.dp.toPx(),
                    center = Offset(normX[it], normY[it])
                )
            }
        }
    }
}

@Composable
fun Graph(
    modifier: Modifier,
    xValues: List<Int>,
    yValues: List<Int>,
    points: List<Float>,
    paddingSpace: Dp,
    verticalStep: Int,
    lineColor: Color,
    showAxis :Boolean
) {
    val controlPoints1 = mutableListOf<PointF>()
    val controlPoints2 = mutableListOf<PointF>()
    val coordinates = mutableListOf<PointF>()
    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.BLACK
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Box(
        modifier = modifier
            .background(Color.Transparent)
            .padding(horizontal = 8.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize(),
        ) {
            val xAxisSpace = (size.width - paddingSpace.toPx()) / xValues.size
            val yAxisSpace = size.height / yValues.size
            if (showAxis){
                /** placing x axis points */
                for (i in xValues.indices) {
                    drawContext.canvas.nativeCanvas.drawText(
                        "${xValues[i]}",
                        xAxisSpace * (i + 1),
                        size.height - 30,
                        textPaint
                    )
                }
                /** placing y axis points */
                for (i in yValues.indices) {
                    drawContext.canvas.nativeCanvas.drawText(
                        "${yValues[i]}",
                        paddingSpace.toPx() / 2f,
                        size.height - yAxisSpace * (i + 1),
                        textPaint
                    )
                }
            }


            /** placing our x axis points */
            for (i in points.indices) {
                val x1 = xAxisSpace * xValues[i]
                val y1 = size.height - (yAxisSpace * (points[i] / verticalStep.toFloat()))
                coordinates.add(PointF(x1, y1))
                /** drawing circles to indicate all the points */
                drawCircle(
                    color = Color(0xFF042B27),
                    radius = 4f,
                    center = Offset(x1, y1)
                )
            }
            /** calculating the connection points */
            for (i in 1 until coordinates.size) {
                controlPoints1.add(
                    PointF(
                        (coordinates[i].x + coordinates[i - 1].x) / 2,
                        coordinates[i - 1].y
                    )
                )
                controlPoints2.add(
                    PointF(
                        (coordinates[i].x + coordinates[i - 1].x) / 2,
                        coordinates[i].y
                    )
                )
            }
            /** drawing the path */
            val stroke = Path().apply {
                reset()
                moveTo(coordinates.first().x, coordinates.first().y)
                for (i in 0 until coordinates.size - 1) {
                    cubicTo(
                        controlPoints1[i].x, controlPoints1[i].y,
                        controlPoints2[i].x, controlPoints2[i].y,
                        coordinates[i + 1].x, coordinates[i + 1].y
                    )
                }
            }

            /** filling the area under the path */
            val fillPath = android.graphics.Path(stroke.asAndroidPath())
                .asComposePath()
                .apply {
                    lineTo(xAxisSpace * xValues.last(), size.height - yAxisSpace)
                    lineTo(xAxisSpace, size.height - yAxisSpace)
                    close()
                }
            drawPath(
                fillPath,
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Cyan,
                        Color.Transparent,
                    ),
                    endY = size.height - yAxisSpace
                ),
            )
            drawPath(
                stroke,
                color = lineColor,
                style = Stroke(
                    width = 5f,
                    cap = StrokeCap.Round
                )
            )
        }
    }
}

@Composable
fun MarketCard1(cardColors: CardColors, priceColor: Color) {
    Card(
        modifier = Modifier
            .padding(top = 4.dp, start = 4.dp, end = 4.dp, bottom = 4.dp)
            .height(200.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = cardColors
    ) {

        Column() {
            Text(
                text = "Dow Jonas",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.LightGray,
                modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 5.dp)
            )
            Text(
                text = "$25.645",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = priceColor,
                modifier = Modifier.padding(start = 15.dp, top = 5.dp, bottom = 5.dp)
            )
            Text(
                text = "↑ 0.15%",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF009688),
                modifier = Modifier.padding(start = 15.dp, bottom = 5.dp)
            )

            val chartEntryModel = entryModelOf(40f, 120f, 80f, 160f)
//            Chart(
//                modifier = Modifier
//                    .height(15.dp)
//                    .width(180.dp),
//                chart = lineChart(),
//                model = chartEntryModel,
//                startAxis = startAxis(axis = LineComponent(R.color.black, 2f, )),
//                bottomAxis = bottomAxis(),
//            )
//            CubicChart(modifier = Modifier
//                .width(180.dp)
//                .height(10.dp), graphColor = Color.DarkGray)

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
                    .width(200.dp)
                    .height(100.dp),
                xValues = (0..9).map { it + 1 },
                yValues = (0..6).map { (it + 1) * yStep },
                points = points,
                paddingSpace = 16.dp,
                verticalStep = yStep,
                lineColor = priceColor,
                false
            )
        }
    }
}

@Composable
fun SearchBar() {
//    val state = rememberSaveable(stateSaver = TextFieldValue.Saver) {
//        mutableStateOf(TextFieldValue(""))
//    }
//
//    val tempViewModel = ViewModelProvider(
//        LocalContext.current as TemplateActivity,
//        TemplateViewModelFactory(getLanguageIso(LocalContext.current))
//    )[TemplateViewModel::class.java]

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
            .border(
                width = 1.dp,
                color = androidx.compose.material3.MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        BasicTextField(
            value = "",
            onValueChange = {
//                state.value = it
//                tempViewModel.searchNow(it.text)
            },
            modifier = Modifier
                .heightIn(min = 45.dp)
                .testTag("search_bar")
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = androidx.compose.material3.MaterialTheme.colorScheme.onBackground
            ),
            cursorBrush = SolidColor(androidx.compose.material3.MaterialTheme.colorScheme.onBackground),
            maxLines = 1,
            singleLine = true,
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                    )
                    Box(
                        modifier = Modifier
                            .weight(1F)
                            .padding(horizontal = 10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
//                        if (state.value == TextFieldValue(""))
                        Text(
                            text = "Search",
                            fontWeight = FontWeight.ExtraLight,
                        )
                        innerTextField()
                    }
                    //    if (state.value != TextFieldValue("")) {
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .clickable {
//                                    state.value = TextFieldValue("")
//                                    tempViewModel.searchNow("")

                            })
                    //  }
                }
            })
    }
}


@Composable
fun StockCard() {
    Card(
        elevation = CardDefaults.cardElevation(1.dp),
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
                    fontSize = 13.sp,
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
                    .align(Alignment.CenterVertically)
                    .padding(8.dp)
            ) {

                Text(
                    text = "25.949",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "↑ 0.15%",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(8.dp)
            ) {

                Text(
                    text = "$254.02",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "10 shares",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        }
    }
}