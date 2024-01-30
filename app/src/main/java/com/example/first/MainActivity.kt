package com.example.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.first.ui.theme.FirstTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstTheme {
                Stuff()
            }
        }
    }
}

@Composable
fun Stuff(){
    // A surface container using the 'background' color from the theme
    Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Box  {
            val image = painterResource(R.drawable.minecraft_background_2)
            Image(
                painter = image,
                contentDescription = "mining",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Greeting(stringResource(R.string.sonic_quote))
        }
    }
}

@Composable
fun Greeting(quote: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Surface(color = Color.White, modifier = modifier.align(alignment = Alignment.End)) {
            Text(
                text = stringResource(R.string.system_message_message),
                fontSize = 17.sp,
                lineHeight = 20.sp,
                modifier = modifier.padding(10.dp)
            )
        }
        Text(
            color = Color.White,
            text = stringResource(R.string.sonic_says),
            fontSize = 25.sp,
            lineHeight = 26.sp,
            modifier = modifier.padding(15.dp),
            textAlign = TextAlign.Center
        )
        Text(
            color = Color.White,
            text = quote,
            fontSize = 60.sp,
            lineHeight = 66.sp,
            modifier = modifier.padding(20.dp),
            textAlign = TextAlign.Center
        )
        val image = painterResource(R.drawable.sonic)
        Image(
            painter = image,
            contentDescription = "sonic",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTheme {
        Stuff()
    }
}