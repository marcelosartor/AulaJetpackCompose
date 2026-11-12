package br.com.msartor.aulajetpackcompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.msartor.aulajetpackcompose.data.remote.model.Destaque
import br.com.msartor.aulajetpackcompose.data.remote.model.Postagem
import br.com.msartor.aulajetpackcompose.data.remote.repository.FeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedRepository: FeedRepository,
) : ViewModel() {

    private val _destaques = MutableLiveData<List<Destaque>>(emptyList())
    val destaques: LiveData<List<Destaque>> = _destaques

    private val _postagens = MutableLiveData<List<Postagem>>(emptyList())
    val postagens: LiveData<List<Postagem>> = _postagens

    fun carregarFeed() {
        viewModelScope.launch {
            val feed = feedRepository.recuperarFeed()
            _destaques.value = feed.destaques
            _postagens.value = feed.postagens
        }
    }
}
