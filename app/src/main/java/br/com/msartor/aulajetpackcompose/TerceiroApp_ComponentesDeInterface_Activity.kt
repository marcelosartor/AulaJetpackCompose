package br.com.msartor.aulajetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.msartor.aulajetpackcompose.model.Usuario
import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme

class TerceiroApp_ComponentesDeInterface_Activity : ComponentActivity() {
    private var opcoesRadio = listOf(
        "Android",
        "Vue",
        "Java",
        "Kotlin",
        "Swift",
        "Objective-C",
        )

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
                TerceiroApp_ComponentesDeInterface()
            }
        }
    }
    /*---------------------------------------------------------------------------------------
    | INICIO DAS FUNCÇÕES DE COMPOSE                                                        |
     ---------------------------------------------------------------------------------------*/
    @SuppressLint("Range")
    @Composable
    fun TerceiroApp_ComponentesDeInterface(){
        var checked by  remember {
            mutableStateOf(false)
        }
        var radioSelecionado by remember {
            mutableStateOf(opcoesRadio[0])
        }



        Column(modifier = Modifier
            .padding(top = 60.dp, bottom = 50.dp) //
            //.background(Color(0xFF009688))
            .background(Color.White)
            .border(2.dp, color = Color.Red)
            .padding(10.dp,10.dp)
            .fillMaxWidth()
            .fillMaxHeight()

        ) {
            ExemploFloatingActionButton()
            ExemploSwitch(checked = checked, onCheckedChange = { checked = it } )
            ExemploCheckbox(checked = checked, onCheckedChange = { checked = it } )
            ExemploRadio(radioSelecionado = radioSelecionado, onClick = { radioSelecionado = it } )
            ExemploCardView()
        }
    }

    @Composable
    fun ExemploCardViewItem(usuario: Usuario){
        Text(modifier = Modifier.padding(5.dp), text = "CardView")
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
            ,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
                ),
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray,
                contentColor = Color(0xFF009688)
            ),
            onClick = {
                Toast.makeText(applicationContext, "Clicou em ${usuario.nome}", Toast.LENGTH_SHORT).show()
            }) {
            Row(modifier = Modifier.padding(2.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.carro),
                    contentDescription = null,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .padding(5.dp)
                        .weight(0.3f),

                    contentScale = ContentScale.Crop
                    )

                Text(modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 5.dp),
                    text = "Nome: ${usuario.nome}" )
                Text(modifier = Modifier.weight(0.2f),
                    text = "Idade: ${usuario.idade}")
            }
        }
    }

    @Composable
    fun ExemploCardView() {
        LazyColumn() {
            items(usuarios){usuario ->
                ExemploCardViewItem(usuario)
            }
        }
    }

    @Composable
    fun ExemploRadio(radioSelecionado: String, onClick: (String) -> Unit) {
        Text(modifier = Modifier.padding(5.dp), text = "Radio Button")
        opcoesRadio.forEach { opcao->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start) {
                RadioButton(selected = radioSelecionado == opcao, onClick = { onClick(opcao) })
                Text(text = opcao)
            }
        }
        HorizontalDivider(Modifier.padding(5.dp))
    }

    @Composable
    private fun ExemploSwitch(
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit
    ) {
        Text(modifier = Modifier.padding(5.dp), text = "Switch")
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        HorizontalDivider(Modifier.padding(5.dp))
    }

    @Composable
    private fun ExemploCheckbox(
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit
    ) {
        Text(modifier = Modifier.padding(5.dp), text = "Checkbox")
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        HorizontalDivider(Modifier.padding(5.dp))
    }

    @Composable
    fun ExemploFloatingActionButton() {
        Text(modifier = Modifier.padding(5.dp), text = "FloatingActionButton")
        FloatingActionButton(
            containerColor = Color.Blue,
            contentColor = Color.White,
            onClick = {
            }
        ) {
            Icon(painter = painterResource(R.drawable.ic_add_24), contentDescription = null)
        }
        HorizontalDivider(Modifier.padding(5.dp))
    }

    @Preview
    @Composable
    fun AppPreview(){
        TerceiroApp_ComponentesDeInterface()
    }

}