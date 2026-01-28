package br.com.msartor.aulajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme

class InstagramScaffoldActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AulaJetpackComposeTheme {
                Scaffold(
                    topBar ={
                        TopAppBar(
                            title = {
                                Text(text = "Instagram")
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar() {
                            Text(text = "bottom")
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {  }) {
                            Icon(painter = painterResource(R.drawable.ic_add_24), contentDescription = null)
                        }
                    }
                ) { paddingInterno ->
                    Home(Modifier.padding(paddingInterno))
                }
            }
        }
    }

    @Composable
    fun Home(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            Text(text = "Ola App!")
        }
    }


    @Preview
    @Composable
    fun AppPreview(){
        Home(Modifier)
    }
}

