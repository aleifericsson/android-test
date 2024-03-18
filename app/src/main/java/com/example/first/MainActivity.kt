package com.example.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstTheme {
                Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(modifier = Modifier
                        .verticalScroll(rememberScrollState())){
                        Stuff()
                        TheApp2()
                    }
                }
            }
        }
    }
}

@Composable
fun Stuff(){
    // A surface container using the 'background' color from the theme
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
                in 6..9 -> stringResource(R.string.sonic_quote3)
                else -> stringResource(R.string.sonic_quote5)
            }

            Greeting(str)
        }

}

@Composable
fun Greeting(quote: String, modifier: Modifier = Modifier) {
    Column(

    ) {
        Surface(color = Color.White, modifier = modifier.align(alignment = Alignment.End)) {
            Text(
                text = stringResource(R.string.system_message_message),
                fontSize = 14.sp,
                lineHeight = 16.sp,
                modifier = modifier
                    .padding(5.dp)
            )
        }
        Text(
            color = Color.White,
            text = stringResource(R.string.sonic_says),
            fontSize = 25.sp,
            lineHeight = 26.sp,
            modifier = modifier.padding(start = 10.dp),
            textAlign = TextAlign.Center
        )
        Text(
            color = Color.White,
            text = quote,
            fontSize = 50.sp,
            lineHeight = 54.sp,
            modifier = modifier.padding(top = 10.dp, bottom = 10.dp, start = 15.dp, end=15.dp),
            textAlign = TextAlign.Center
        )
        var result by remember { mutableIntStateOf( 22) }

        val image = when (result) {
            1 -> painterResource(R.drawable.blaze)
            in 2..6 -> painterResource(R.drawable.sonic1)
            in 7..11 -> painterResource(R.drawable.sonic2)
            in 12..16 -> painterResource(R.drawable.sonic3)
            in 17..21 -> painterResource(R.drawable.sonic4)
            else -> painterResource(R.drawable.sonic5)
        }
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){

            Surface(color = Color.hsl(240F, 0.85F,0.25F),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ){
                Button(
                    onClick = { result = (1..25).random() },
                    modifier = Modifier
                        .padding(15.dp)
                        .height(75.dp)
                ) {
                    Text(
                        text = stringResource(R.string.change_sonic),
                        fontSize = 30.sp,
                        lineHeight = 35.sp
                    )
                }
            }
            Surface(color = Color.hsl(240F, 0.85F,0.25F),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ){
                Text(
                    text = stringResource(R.string.escape_from_the_city),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )
            }
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
        Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        inst.GetComponent()
            Stuff()
            TheApp2()
        }
    }
}


@Composable
fun TheApp2(modifier: Modifier = Modifier){
    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0//wow it's like javascript
    var percentInput by remember { mutableStateOf( "15.0")}
    val percent = percentInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, percent)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 30.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            bruh = amountInput,
            onBruhChange = {amountInput = it},
            label = R.string.bill_amount,
            keyOps = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField(
            bruh = percentInput,
            onBruhChange = {percentInput = it},
            label = R.string.tip_percentage,
            keyOps = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    bruh: String,
    onBruhChange: (String) -> Unit, //bruh moment
    keyOps: KeyboardOptions,
    modifier: Modifier = Modifier){
    TextField(
        value = bruh,
        onValueChange = onBruhChange,
        modifier = modifier,
        label = {Text(stringResource(label))},
        singleLine = true,
        keyboardOptions = keyOps
    )
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String{
    val tip = tipPercent / 100*amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

