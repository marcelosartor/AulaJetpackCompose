package br.com.msartor.aulajetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.msartor.aulajetpackcompose.model.Usuario

import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme

class MainActivity : ComponentActivity() {
    private val usuarios = listOf(
        Usuario("Marcelo",52),
        Usuario("Vanessa",53),
        Usuario("Joao",25),
        Usuario("Mickey",3),
        Usuario("Rose",3),
        Usuario("Nemo",1),
        Usuario("Guloso",1),
        Usuario("Comilão",1),
        Usuario("Barney",12),
        Usuario("Ruff",13),
        Usuario("Rex",0),

        /*
        Usuario("Marcelo",52),
        Usuario("Vanessa",53),
        Usuario("Joao",25),
        Usuario("Mickey",3),
        Usuario("Rose",3),
        Usuario("Nemo",1),
        Usuario("Guloso",1),
        Usuario("Comilão",1),
        Usuario("Barney",12),
        Usuario("Ruff",13),
        Usuario("Rex",0),

        Usuario("Marcelo",52),
        Usuario("Vanessa",53),
        Usuario("Joao",25),
        Usuario("Mickey",3),
        Usuario("Rose",3),
        Usuario("Nemo",1),
        Usuario("Guloso",1),
        Usuario("Comilão",1),
        Usuario("Barney",12),
        Usuario("Ruff",13),
        Usuario("Rex",0),
        */
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AulaJetpackComposeTheme {
                PrimeiroApp()
            }
        }
    }

    /*---------------------------------------------------------------------------------------
    | INICIO DAS FUNCÇÕES DE COMPOSE                                                        |
    ----------------------------------------------------------------------------------------*/
    @SuppressLint("Range")
    @Composable
    fun PrimeiroApp(){
        Column(modifier = Modifier
            //.width(200.dp)
            //.height(200.dp)
            .background(Color.Gray)
            .border(2.dp, color = Color.Red)
            .padding(0.dp,10.dp)
            .fillMaxWidth()
            .fillMaxHeight()

        ) {



            LazyVerticalGrid(
                //columns = GridCells.Adaptive(122.dp),
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(10.dp)
            ) {
                items(usuarios.size){item->
                    val nome = usuarios[item].nome
                    val idade = usuarios[item].idade

                    Row(modifier=Modifier
                        .padding(2.dp)
                        .border(2.dp, color = Color.Red,RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                        .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        perfilDeUsurioColumn(nome.substring(0, 1))
                        Text(
                            text = "$nome",
                            fontSize = 24.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)

                        )
                    }
                }
            }
            /*


            LazyHorizontalGrid(
                //columns = GridCells.Adaptive(122.dp),
                rows = GridCells.Fixed(3),
                modifier = Modifier.padding(10.dp)
                    .width(300.dp)
                    .fillMaxWidth()
                    .height(200.dp)

            ) {
                items(usuarios.size){item->
                    val nome = usuarios[item].nome
                    val idade = usuarios[item].idade
                    Row(
                        modifier = Modifier
                            .height(64.dp)
                            .width(300.dp)
                            .padding(2.dp)
                            .border(
                                2.dp,
                                color = Color.Red,
                                RoundedCornerShape(10.dp)
                            )
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        perfilDeUsurioColumn(nome.substring(0, 1))
                        Text(
                            text = nome,
                            fontSize = 24.sp,
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .weight(1f)
                        )
                    }

                }
            }
            */

            /*
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(usuarios.size){item->
                    val nome = usuarios[item].nome
                    val idade = usuarios[item].idade

                    Row(modifier=Modifier
                        .border(2.dp, color = Color.Red,RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                        .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        perfilDeUsurioColumn(nome.substring(0, 1))
                        Text(
                            text = "$nome - $idade",
                            fontSize = 24.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)

                        )
                    }
                    Box(Modifier
                       .padding(10.dp)
                       .fillMaxWidth()
                       .height(1.dp)
                       .background(Color.Blue))
                }
            }
             */
        }

    }

    @Preview
    @Composable
    fun PrimeiroAppPreview(){
        PrimeiroApp()
    }


}


@Composable
fun perfilDeUsurio(text: String){
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .border(2.dp, color = Color.Red,  CircleShape)
            .clip(shape = CircleShape)
            //.clip(shape = RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp))
            //.clip(CutCornerShape(10.dp))
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = text, fontSize = 32.sp)
    }
}

@Composable
fun perfilDeUsurioColumn(text: String ){
    Box(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .border(2.dp, Color.Red, CircleShape)
            .clip(CircleShape)
            .background(Color.Green),

        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
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