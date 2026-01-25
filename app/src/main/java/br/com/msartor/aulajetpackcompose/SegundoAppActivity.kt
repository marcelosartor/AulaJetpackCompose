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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.msartor.aulajetpackcompose.model.Usuario
import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme

class SegundoAppActivity : ComponentActivity() {
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
        Usuario("Rex",0)
    )

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
        var listaUsuarios by remember {
            mutableStateOf(listOf<Usuario>())
        }


        Column(modifier = Modifier
            .padding(top = 50.dp) //
            .background(Color.White)
            .border(2.dp, color = Color.Red)
            //.padding(10.dp,10.dp)
            .fillMaxWidth()
            .fillMaxHeight()

        ) {
            Row(modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    modifier = Modifier.padding(10.dp),
                    value = nome,
                    onValueChange = { texto ->
                        nome = texto
                        Log.i("COMPOSE_TextField", "Sobrenome: ${nome}")
                    },
                    label = { Text("Digite seu nome") },
                )
                //Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {
                        val usuario = Usuario(nome,0)
                        listaUsuarios = listaUsuarios + usuario
                        nome = ""
                        //Log.i("COMPOSE_TextField", "Sobrenome: ${nome}")
                    }) {
                    Icon(painter = painterResource(R.drawable.ic_add_24), contentDescription = null)
                }
            }

            LazyColumn(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
                items(listaUsuarios){usuario ->
                    Text(modifier = Modifier.padding(16.dp),
                        text = "+) ${usuario.nome}")
                    HorizontalDivider()
                }
            }


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