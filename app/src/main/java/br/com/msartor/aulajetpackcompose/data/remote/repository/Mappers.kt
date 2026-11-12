package br.com.msartor.aulajetpackcompose.data.remote.repository

import br.com.msartor.aulajetpackcompose.data.remote.dto.PostDto
import br.com.msartor.aulajetpackcompose.data.remote.dto.UserDto
import br.com.msartor.aulajetpackcompose.data.remote.model.Destaque
import br.com.msartor.aulajetpackcompose.data.remote.model.Postagem

// Se o JSON da API mudar, só este arquivo precisa ser ajustado: a UI só conhece os modelos.

internal fun UserDto.toDestaque() = Destaque(
    id = id,
    nome = firstName,
    imagemPerfilUrl = image,
)

internal fun PostDto.toPostagem(autor: UserDto?) = Postagem(
    id = id,
    nome = autor?.firstName.orEmpty(),
    imagemPerfilUrl = autor?.image.orEmpty(),
    fotoUrl = "https://picsum.photos/seed/$id/600/400",
    descricao = body,
)
