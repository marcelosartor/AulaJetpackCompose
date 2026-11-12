package br.com.msartor.aulajetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.msartor.aulajetpackcompose.data.remote.repository.FeedRepository
import br.com.msartor.aulajetpackcompose.ui.view.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedRepository: FeedRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Carregando)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    // O ViewModel sobrevive à rotação: o carregamento acontece uma vez só.
    init {
        carregarFeed()
    }

    fun carregarFeed() {
        _uiState.value = HomeUiState.Carregando
        viewModelScope.launch {
            _uiState.value = feedRepository.recuperarFeed().fold(
                onSuccess = { HomeUiState.Sucesso(it.destaques, it.postagens) },
                onFailure = { HomeUiState.Erro(it.message ?: "Não foi possível carregar o feed") },
            )
        }
    }
}
