package br.com.msartor.aulajetpackcompose.data.remore.repository

import br.com.msartor.aulajetpackcompose.data.remore.dto.User

interface IUsuariosRepository {
    suspend fun recuperarUsuarios(): List<User>
}

