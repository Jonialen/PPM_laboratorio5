package com.example.lab5jonathandiaz

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5jonathandiaz.ui.theme.Lab5JonathanDiazTheme
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.platform.LocalContext

class Concerts : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5JonathanDiazTheme {
                ConcertsBase()
            }
        }
    }
}

@Composable
fun ConcertsBase() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.statusBarsPadding()
    ) {
        TitleApp {
            val intent = Intent(context, Profile::class.java)
            context.startActivity(intent)
        }
        ConcertListScreen()
    }
}


@Composable
fun TitleApp(navigateToProfile: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "TodoEventos", style = MaterialTheme.typography.titleLarge)
        IconButton(onClick = { navigateToProfile() }) {
            Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
        }
    }
}


@Composable
fun ConcertListScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier.fillMaxSize()) {
        Text("Your favorites", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(4) { index ->
                ConcertItem(title = "Concierto $index") { title ->
                    // Abrimos ListPlaces pasando el título del concierto
                    val intent = Intent(context, ListPlaces::class.java).apply {
                        putExtra("concert_title", title)
                    }
                    context.startActivity(intent)
                }
            }
        }

        Text("All Concerts", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(8.dp))

        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(10) { index ->
                ConcertItem(title = "Concierto $index") { title ->
                    val intent = Intent(context, ListPlaces::class.java).apply {
                        putExtra("concert_title", title)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}


@Composable
fun ConcertItem(title: String, onItemClicked: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClicked(title) }, // Aquí pasamos el título cuando se presiona
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.hora_en_guatemala_de_los_conciertos_en_linea_de_pitbull_octubre_2020_885x500),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
            )
            Text(
                text = title, // Muestra el título
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Supporting text",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab5JonathanDiazTheme {
        ConcertsBase()
    }
}