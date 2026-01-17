package br.com.msartor.aulajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AulaJetpackComposeTheme {
                PrimeiroApp()
            }
        }
    }
}

/*---------------------------------------------------------------------------------------
| INICIO DAS FUNCÇÕES DE COMPOSE                                                        |
----------------------------------------------------------------------------------------*/
@Composable
fun PrimeiroApp(){

    Column(modifier = Modifier
        //.width(200.dp)
        //.height(200.dp)
        .background(Color.Gray)
        .border(2.dp, color = Color.Red)
        .padding(30.dp,10.dp)
        .fillMaxWidth()
        .fillMaxHeight()

    ) {
        Text(text = "Marcelo e Vanessa", fontSize = 20.sp)
        perfilDeUsurio("MS")
        perfilDeUsurioComImagem()
        Icon(painter = painterResource(id = R.drawable.ic_add_location_24), contentDescription = "MS")
        Icon(imageVector = Icons.Default.Lock, contentDescription = "MS")

        Button(onClick = {},
            ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(id = R.drawable.ic_add_location_24), contentDescription = "MS")
                Text(text = "Localização(GPS)", fontSize = 8.sp)
            }
        }

    }

    /*Text(
        text = "Meu primeiro texto 2",
        color = Color.Black
    )*/
    /*Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background( Color.Gray),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyButton("Meu texto") { }
        Row(modifier = Modifier
            .fillMaxWidth()
            .background( Color.Red),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        )
        {

            Text(text = "col 1", color = Color.Black, fontSize = 24.sp )
            Text(text = "col 2", color = Color.Black, fontSize = 24.sp )
            Text(text = "col 3", color = Color.Black, fontSize = 24.sp )
        }

        Text(text = "linha 1", color = Color.Black, fontSize = 24.sp )
        Text(text = "Linha 2", color = Color.Black, fontSize = 24.sp )
        Text(text = "Linha 3", color = Color.Black, fontSize = 24.sp )


        *//*Button(onClick = {}) {
            Text(
                text = "Meu primeiro texto 2",
                color = Color.Black
            )
        }*//*
    }*/

}
@Composable
fun perfilDeUsurio(text: String){
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .border(2.dp, color = Color.Red, RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp))
            //.clip(shape = CircleShape)
            .clip(shape = RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp))
            //.clip(CutCornerShape(10.dp))
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "MS", fontSize = 32.sp)
    }
}

@Composable
fun perfilDeUsurioComImagem(){
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .border(2.dp, color = Color.Blue, CircleShape)
            //.clip(shape = CircleShape)
            .clip(shape = CircleShape)
            //.clip(CutCornerShape(10.dp))
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.clip(shape = CircleShape)
                .fillMaxWidth()
                .fillMaxHeight(),
            painter = painterResource(id = R.drawable.carro),
            contentDescription = "MS",
            contentScale = ContentScale.Crop
        )


    }
}

@Preview
@Composable
fun PrimeiroAppPreview(){
    PrimeiroApp()
}



/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AulaJetpackComposeTheme {
        Greeting("Android")
    }
}
 */