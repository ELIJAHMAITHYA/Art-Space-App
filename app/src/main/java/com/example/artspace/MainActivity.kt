package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    var next by remember { mutableStateOf(1) }
    //var previous by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        when(next) {
            1 -> {
               
            }
            2 -> {
                Image(painter = painterResource(R.drawable.girl_gd6fede4da_1920), contentDescription = null)

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "ArtWork Title")
                    Text(text = "Artwork Artist (Year)")

                }

                Spacer(modifier = Modifier.height(16.dp))
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
                        next--
                        if(next < 1) {
                            next = 1
                        }
                    }
                )
            }
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                ButtonFunction(
                    "Next",
                    onClick = { next++ }
                )
            }
        }

    }
}
@Composable
fun ArtWorkAndDetail(
    painter: Painter,
    contentDescription: String,
    @StringRes title: Int,
    @StringRes artist: Int,
){
    Image(painter = painter, contentDescription = contentDescription)

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