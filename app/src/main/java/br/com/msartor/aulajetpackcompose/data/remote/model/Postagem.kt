package br.com.msartor.aulajetpackcompose.data.remote.model

data class Postagem(
    val id: Int,
    val nome: String,
    val imagemPerfilUrl: String,
    val fotoUrl: String,
    val descricao: String,
)
