package br.com.msartor.aulajetpackcompose.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.msartor.aulajetpackcompose.viewmodel.FeedViewModel

/** Composable de rota: liga o ViewModel à tela sem estado. */
@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel = viewModel(),
) {
    // Para de coletar quando o app vai para o background.
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Home(
        uiState = uiState,
        onTentarNovamente = viewModel::carregarFeed,
        modifier = modifier,
    )
}
