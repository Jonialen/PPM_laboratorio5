package com.example.lab5jonathandiaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5jonathandiaz.ui.theme.Lab5JonathanDiazTheme

class Details : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5JonathanDiazTheme {
                Scaffold(
                    content = { innerPadding ->
                        ConcertDetailScreen(Modifier.padding(innerPadding))
                    }
                )
            }
        }
    }
}

@Composable
fun ConcertDetailScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
        .statusBarsPadding()){

        titleConcert()
        Spacer(modifier = Modifier.height(8.dp))
        DayDate()
        Spacer(modifier = Modifier.height(8.dp))
        AboutEvent()
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Button(onClick = { /* TODO: Add to favorites */ }, modifier = Modifier.weight(1f)) {
                Text("Favorite")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { /* TODO: Buy ticket */ }, modifier = Modifier.weight(1f)) {
                Text("Buy")
            }
        }
    }
}

@Composable
fun titleConcert() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.istock_951942394),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = "Lugar",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun DayDate() {
    Row {
        Text("Fecha", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
        Text("Hora", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
    }
}

@Composable
fun AboutEvent() {
    Column {
        Text("About", style = MaterialTheme.typography.bodyLarge)
        Text("Lorem ipsum odor amet, consectetuer adipiscing elit. Conubia tincidunt metus eu dis mattis. Curabitur quisque adipiscing molestie magnis natoque. Nec arcu class taciti; mus fringilla fringilla. Netus non lectus enim senectus duis ultricies mi. Enim tempus consectetur orci eu nascetur ut conubia aptent. Iaculis suspendisse imperdiet urna potenti condimentum consequat. Enim ipsum hendrerit bibendum non viverra ante lectus, nunc euismod. Curae nullam cras etiam augue consectetur ultricies imperdiet hendrerit.", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun ConcertDetailScreenPreview() {
    Lab5JonathanDiazTheme {
        ConcertDetailScreen()
    }
}
