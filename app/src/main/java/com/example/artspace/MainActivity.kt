package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}
@Composable
fun ArtSpaceScreen(){
    var nextOrPrevious by remember { mutableStateOf(1) }
    //var previous by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        when(nextOrPrevious) {
            1 -> {
               ArtWorkAndDetail(
                   painter = painterResource(R.drawable.girl_gd6fede4da_1920),
                   contentDescription = null,
                   title = R.string.title_1,
                   artist = R.string.artist_1
               )
            }
            2 -> {
                ArtWorkAndDetail(
                    painter = painterResource(R.drawable.bicycle_ga6e03c665_1920),
                    contentDescription = null,
                    title = R.string.title_2,
                    artist = R.string.artist_2
                )
            }
            3 -> {
                ArtWorkAndDetail(
                    painter = painterResource(R.drawable.burkina_faso_g568b0c73b_1280),
                    contentDescription = null,
                    title = R.string.title_3,
                    artist = R.string.artist_3
                )
            }
            4 -> {
                ArtWorkAndDetail(
                    painter = painterResource(R.drawable.security_gb7194eb70_1920),
                    contentDescription = null,
                    title = R.string.title_4,
                    artist = R.string.artist_4
                )
            }
            5 -> {
                ArtWorkAndDetail(
                    painter = painterResource(R.drawable.easter_g74b67ef05_1920),
                    contentDescription = null,
                    title = R.string.title_5,
                    artist = R.string.artist_5
                )
            }
            6 -> {
                ArtWorkAndDetail(
                    painter = painterResource(R.drawable.burkina_faso_g6668fc364_1920),
                    contentDescription = null,
                    title = R.string.title_6,
                    artist = R.string.artist_6
                )
            }
            7 -> {
                ArtWorkAndDetail(
                    painter = painterResource(R.drawable.breast_g96242091e_1920),
                    contentDescription = null,
                    title = R.string.title_7,
                    artist = R.string.artist_7
                )
            }
            8 -> {
                ArtWorkAndDetail(
                    painter = painterResource(R.drawable.fantastic_g1b412d05b_1920),
                    contentDescription = null,
                    title = R.string.title_8,
                    artist = R.string.artist_8
                )
            }
            9 -> {
                ArtWorkAndDetail(
                    painter = painterResource(R.drawable.universe_g801b7a225_1920),
                    contentDescription = null,
                    title = R.string.title_9,
                    artist = R.string.artist_9
                )
            }
            10 -> {
                ArtWorkAndDetail(
                    painter = painterResource(R.drawable.fantasy_ga0ec85667_1920),
                    contentDescription = null,
                    title = R.string.title_10,
                    artist = R.string.artist_10
                )
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                ButtonFunction(
                    "Previous",
                    onClick = {
                        nextOrPrevious--
                        if(nextOrPrevious < 1) {
                            nextOrPrevious = 1
                        }
                    }
                )
            }
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                ButtonFunction(
                    "Next",
                    onClick = {
                        nextOrPrevious++
                        if(nextOrPrevious > 10) {
                            nextOrPrevious = 1
                        }
                    }
                )
            }
        }

    }
}
@Composable
fun ArtWorkAndDetail(
    painter: Painter,
    contentDescription: String?,
    @StringRes title: Int,
    @StringRes artist: Int,
){
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = Modifier
                    .border(3.dp, Color.DarkGray)
                    .padding(20.dp)
    )


    Spacer(modifier = Modifier.height(16.dp))

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(title))
        Text(text = stringResource(artist))

    }

    Spacer(modifier = Modifier.height(16.dp))
}
@Composable
fun ButtonFunction(
    buttonText: String,
    onClick: () -> Unit
    ) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier.size(width=150.dp, height = 50.dp)
    ) {
        Text(text = buttonText)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}
