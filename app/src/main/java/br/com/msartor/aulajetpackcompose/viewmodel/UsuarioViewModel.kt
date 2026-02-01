package br.com.msartor.aulajetpackcompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.msartor.aulajetpackcompose.data.remore.dto.User
import br.com.msartor.aulajetpackcompose.data.remore.repository.IUsuariosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsuarioViewModel
    @Inject
    constructor(
        private val usuariosRepository: IUsuariosRepository
    ) : ViewModel(){

    private val mUsuarios  = MutableLiveData<List<User>>()
    val usuarios: LiveData<List<User>> = mUsuarios

    fun recuperarUsuarios() {

        viewModelScope.launch {
            val listaUsuarios = usuariosRepository.recuperarUsuarios()
            mUsuarios.postValue(listaUsuarios)
        }
    }

}