package br.com.msartor.aulajetpackcompose.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import br.com.msartor.aulajetpackcompose.viewmodel.FeedViewModel

/** Composable de rota: liga o ViewModel à tela sem estado. */
@Composable
fun HomeRoute(viewModel: FeedViewModel, modifier: Modifier = Modifier) {
    val destaques by viewModel.destaques.observeAsState(initial = emptyList())
    val postagens by viewModel.postagens.observeAsState(initial = emptyList())

    Home(
        destaques = destaques,
        postagens = postagens,
        modifier = modifier,
    )
}
