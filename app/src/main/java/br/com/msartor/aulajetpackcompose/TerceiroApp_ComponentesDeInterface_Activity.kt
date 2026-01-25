package br.com.msartor.aulajetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            .padding(top = 50.dp) //
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
    fun AppComponentesDeInterfacePreview(){
        TerceiroApp_ComponentesDeInterface()
    }
}