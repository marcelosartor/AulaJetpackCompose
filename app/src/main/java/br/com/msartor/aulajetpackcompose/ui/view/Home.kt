package br.com.msartor.aulajetpackcompose.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.msartor.aulajetpackcompose.data.remote.model.Destaque
import br.com.msartor.aulajetpackcompose.data.remote.model.Postagem
import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme
import br.com.msartor.aulajetpackcompose.ui.view.components.AreaDestaque
import br.com.msartor.aulajetpackcompose.ui.view.components.AreaPostagem
import br.com.msartor.aulajetpackcompose.ui.view.components.BarraInferior
import br.com.msartor.aulajetpackcompose.ui.view.components.BarraSuperior

/** Tela sem estado: recebe tudo por parâmetro. Não conhece ViewModel nem Activity. */
@Composable
fun Home(
    destaques: List<Destaque>,
    postagens: List<Postagem>,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior() },
    ) { paddingInterno ->
        Column(modifier = Modifier.padding(paddingInterno)) {
            AreaDestaque(listaDestaques = destaques)
            HorizontalDivider()
            AreaPostagem(listaPostagens = postagens)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    AulaJetpackComposeTheme {
        Home(
            destaques = List(8) { Destaque(it, "Fulano $it", "") },
            postagens = List(3) {
                Postagem(it, "Fulano $it", "", "", "Descrição da postagem $it")
            },
        )
    }
}
