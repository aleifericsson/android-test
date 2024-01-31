package com.example.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.foundation.layout.width
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

            val str = when ((0..10).random()){
                in 1..3 -> stringResource(R.string.sonic_quote1)
                4,5,8 -> stringResource(R.string.sonic_quote2)
                7 -> stringResource(R.string.sonic_quote4)
                in 6..10 -> stringResource(R.string.sonic_quote3)
                else -> stringResource(R.string.sonic_quote5)
            }

            Greeting(str)
        }
    }
}

@Composable
fun Greeting(quote: String, modifier: Modifier = Modifier) {
    Column(
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
        Surface(
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
        ) {
            Image(
                painter = image,
                contentDescription = "sonic",
                modifier = Modifier.padding(10.dp)
            )
        }

        Surface(
            color = Color.White,
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
        ){}
        Surface(
            color = Color.hsl(240F, 0.85F,0.25F),
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                text = stringResource(R.string.escape_from_the_city),
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

class BoxThing(val height:Int, val width:Int, val name:String){
    val color = Color.White
    var textcol = Color.Black
    constructor( height:Int, width:Int, color: Color):this(height,width,"null") {
        textcol = Color.White
    }
    @Composable
    fun GetComponent(){
        return(
                Surface(
                    color = this.color,
                    modifier = Modifier
                        .height(this.height.dp)
                        .width(this.width.dp)
                ){
                    Text(
                        text = this.name,
                        color = this.textcol,
                    )
                })
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTheme {
        val inst = BoxThing(100,200,Color.Blue)
        inst.GetComponent()
        Stuff()
    }
}