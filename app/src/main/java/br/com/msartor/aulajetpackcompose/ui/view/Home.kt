package br.com.msartor.aulajetpackcompose.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.msartor.aulajetpackcompose.R
import br.com.msartor.aulajetpackcompose.data.remote.model.Destaque
import br.com.msartor.aulajetpackcompose.data.remote.model.Postagem
import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme
import br.com.msartor.aulajetpackcompose.ui.view.components.AreaDestaque
import br.com.msartor.aulajetpackcompose.ui.view.components.AreaPostagem
import br.com.msartor.aulajetpackcompose.ui.view.components.BarraInferior
import br.com.msartor.aulajetpackcompose.ui.view.components.BarraSuperior

/** Tela sem estado: recebe tudo por parâmetro e devolve eventos por lambda. */
@Composable
fun Home(
    uiState: HomeUiState,
    onTentarNovamente: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior() },
    ) { paddingInterno ->
        val conteudo = Modifier.padding(paddingInterno)
        when (uiState) {
            HomeUiState.Carregando -> Box(conteudo.fillMaxSize(), Alignment.Center) {
                CircularProgressIndicator()
            }

            is HomeUiState.Erro -> Column(
                modifier = conteudo.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = uiState.mensagem)
                Button(onClick = onTentarNovamente) {
                    Text(text = stringResource(R.string.tentar_novamente))
                }
            }

            is HomeUiState.Sucesso -> Column(modifier = conteudo) {
                AreaDestaque(listaDestaques = uiState.destaques)
                HorizontalDivider()
                AreaPostagem(listaPostagens = uiState.postagens)
            }
        }
    }
}

private val sucessoExemplo = HomeUiState.Sucesso(
    destaques = List(8) { Destaque(it, "Fulano $it", "") },
    postagens = List(3) { Postagem(it, "Fulano $it", "", "", "Descrição da postagem $it") },
)

@Preview(showBackground = true)
@Composable
private fun HomeSucessoPreview() {
    AulaJetpackComposeTheme { Home(sucessoExemplo, onTentarNovamente = {}) }
}

@Preview(showBackground = true)
@Composable
private fun HomeCarregandoPreview() {
    AulaJetpackComposeTheme { Home(HomeUiState.Carregando, onTentarNovamente = {}) }
}

@Preview(showBackground = true)
@Composable
private fun HomeErroPreview() {
    AulaJetpackComposeTheme { Home(HomeUiState.Erro("Sem conexão"), onTentarNovamente = {}) }
}
