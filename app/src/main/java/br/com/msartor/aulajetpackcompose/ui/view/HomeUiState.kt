package br.com.msartor.aulajetpackcompose.ui.view

import br.com.msartor.aulajetpackcompose.data.remote.model.Destaque
import br.com.msartor.aulajetpackcompose.data.remote.model.Postagem

/** Estado único da tela: a UI é função deste valor. */
sealed interface HomeUiState {
    data object Carregando : HomeUiState

    data class Sucesso(
        val destaques: List<Destaque>,
        val postagens: List<Postagem>,
    ) : HomeUiState

    data class Erro(val mensagem: String) : HomeUiState
}
