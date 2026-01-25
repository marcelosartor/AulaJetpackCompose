package br.com.msartor.aulajetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme

class SegundoAppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AulaJetpackComposeTheme {
                SegundoApp()
            }
        }
    }
    /*---------------------------------------------------------------------------------------
    | INICIO DAS FUNCÇÕES DE COMPOSE                                                        |
     ---------------------------------------------------------------------------------------*/
    @SuppressLint("Range")
    @Composable
    fun SegundoApp(){
        var contator by  remember {
            mutableIntStateOf(0)
        }
        var nome by  remember {
            mutableStateOf("")
        }
        var sobreNome by  remember {
            mutableStateOf("")
        }

        Column(modifier = Modifier
            .padding(top = 50.dp) //
            .background(Color.White)
            .border(2.dp, color = Color.Red)
            .padding(10.dp,10.dp)
            .fillMaxWidth()
            .fillMaxHeight()

        ) {
            TextField(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                value = nome,
                onValueChange = { texto ->
                    nome = texto
                    Log.i("COMPOSE_TextField", "Nome: ${nome}")
                },
                label = { Text("Digite seu nome") },

            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                value = sobreNome,
                onValueChange = { texto ->
                    sobreNome = texto
                    Log.i("COMPOSE_TextField", "Sobrenome: ${sobreNome}")
                },
                label = { Text("Digite seu nome") },

            )
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                contator++
                Log.i("COMPOSE_Contador", "Contador: ${contator}")
            }) {
                Text("Click")
            }
            Text(modifier = Modifier.padding(10.dp),
                text = "Contador: ${contator}")
            Text(modifier = Modifier.padding(10.dp),
                text = "Nome: ${nome}")
            Text(modifier = Modifier.padding(10.dp),
                text = "Sobrenome: ${sobreNome}")
            CardExample()
        }
    }

    @Composable
    fun CardExample() {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .size(width = 240.dp, height = 100.dp)
        ) {
            Text(
                text = "Filled",
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
        }
    }

    @Preview
    @Composable
    fun AppPreview(){
        SegundoApp()
    }
}