package com.example.lab5jonathandiaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.lab5jonathandiaz.ui.theme.Lab5JonathanDiazTheme

class ListPlaces : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5JonathanDiazTheme {
                Scaffold(
                    content = { innerPadding ->
                        PlacesListScreen(Modifier.padding(innerPadding))
                    }
                )
            }
        }
    }
}

@Composable
fun PlacesListScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(10) {
            ConcertItemInfo()
            HorizontalDivider()
        }
    }
}

@Composable
fun ConcertItemInfo() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundImageWithText(text = "Title")

            Column(
                modifier = Modifier.alignByBaseline()
            ) {
                Text(
                    text = "Title",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Supporting text",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Icon(
                Icons.Rounded.KeyboardArrowDown,
                contentDescription = null
            )
        }
    }
}

@Composable
fun RoundImageWithText(text: String, modifier: Modifier = Modifier, size: Dp = 40.dp) {
    val initials = text.split(" ").mapNotNull { it.firstOrNull()?.toString() }.joinToString("")

    val circleColor = MaterialTheme.colorScheme.primary
    val textColor = MaterialTheme.colorScheme.onPrimary


    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
    ) {
        Canvas(
            modifier = modifier
                .size(size)
        ) {
            drawCircle(
                color = circleColor
            )
        }
        Text(
            text = initials,
            color = textColor,
            style = MaterialTheme.typography.titleMedium
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PlacesListScreenPreview() {
    Lab5JonathanDiazTheme {
        PlacesListScreen()
    }
}
