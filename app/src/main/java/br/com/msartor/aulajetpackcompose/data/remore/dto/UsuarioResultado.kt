package br.com.msartor.aulajetpackcompose.data.remore.dto

data class UsuarioResultado(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)