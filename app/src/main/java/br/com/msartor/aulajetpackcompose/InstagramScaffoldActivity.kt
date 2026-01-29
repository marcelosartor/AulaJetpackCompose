package br.com.msartor.aulajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.msartor.aulajetpackcompose.components.AreaDestaque
import br.com.msartor.aulajetpackcompose.components.AreaPostagem
import br.com.msartor.aulajetpackcompose.components.BarraInferior
import br.com.msartor.aulajetpackcompose.components.BarraSuperior
import br.com.msartor.aulajetpackcompose.model.Destaque
import br.com.msartor.aulajetpackcompose.model.Postagem
import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme

class InstagramScaffoldActivity : ComponentActivity() {

    private val listaDestaques = listOf<Destaque>(
        Destaque(imagemPerfilRes = R.drawable.perfil_01, nome = "Fulano 01"),
        Destaque(imagemPerfilRes = R.drawable.perfil_02, nome = "Fulano 02"),
        Destaque(imagemPerfilRes = R.drawable.perfil_03, nome = "Fulano 03"),
        Destaque(imagemPerfilRes = R.drawable.perfil_01, nome = "Fulano 04"),
        Destaque(imagemPerfilRes = R.drawable.perfil_02, nome = "Fulano 05"),
        Destaque(imagemPerfilRes = R.drawable.perfil_03, nome = "Fulano 06"),
        Destaque(imagemPerfilRes = R.drawable.perfil_01, nome = "Fulano 07"),
        Destaque(imagemPerfilRes = R.drawable.perfil_02, nome = "Fulano 08"),
        Destaque(imagemPerfilRes = R.drawable.perfil_03, nome = "Fulano 09"),
        Destaque(imagemPerfilRes = R.drawable.perfil_01, nome = "Fulano 10"),
        Destaque(imagemPerfilRes = R.drawable.perfil_02, nome = "Fulano 11"),
        Destaque(imagemPerfilRes = R.drawable.perfil_03, nome = "Fulano 12"),
    )

    private val listaPostagens = listOf<Postagem>(
        Postagem(imagemPerfilRes = R.drawable.perfil_01, nome = "Fulano 01", fotoRes = R.drawable.carro, descricao = "Uma Carro Especial"),
        Postagem(imagemPerfilRes = R.drawable.perfil_02, nome = "Fulano 02", fotoRes = R.drawable.floresta, descricao = "Mussum Ipsum, cacilds vidis litro abertis. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo! Quem manda na minha terra sou euzis! Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus. Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum."),
        Postagem(imagemPerfilRes = R.drawable.perfil_03, nome = "Fulano 03", fotoRes = R.drawable.praia, descricao = "Mussum Ipsum, cacilds vidis litro abertis. Pellentesque nec nulla ligula. Donec gravida turpis a vulputate ultricies. Interagi no mé, cursus quis, vehicula ac nisi. A ordem dos tratores não altera o pão duris. Mé faiz elementum girarzis, nisi eros vermeio."),
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AulaJetpackComposeTheme {
                Scaffold(
                    topBar ={ BarraSuperior() },
                    bottomBar = { BarraInferior() } ,
                    /*
                    floatingActionButton = {
                        FloatingActionButton(onClick = {  }) {
                            Icon(painter = painterResource(R.drawable.ic_add_24), contentDescription = null)
                        }
                    }
                     */
                ) { paddingInterno ->
                    Home(Modifier.padding(paddingInterno))
                }
            }
        }
    }

    @Composable
    fun Home(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            // Area Destaque
            AreaDestaque(listaDestaques = listaDestaques)
            HorizontalDivider()
            AreaPostagem(listaPostagem = listaPostagens)
        }
    }


    @Preview
    @Composable
    fun AppPreview(){
        Home(Modifier)
    }
}

