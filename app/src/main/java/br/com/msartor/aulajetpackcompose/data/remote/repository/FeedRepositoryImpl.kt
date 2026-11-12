package br.com.msartor.aulajetpackcompose.data.remote.repository

import android.util.Log
import br.com.msartor.aulajetpackcompose.data.remote.api.DummyApi
import br.com.msartor.aulajetpackcompose.data.remote.model.Feed
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val dummyApi: DummyApi,
) : FeedRepository {

    override suspend fun recuperarFeed(): Feed =
        try {
            val usuarios = dummyApi.recuperarUsuarios().users
            val posts = dummyApi.recuperarPostagens().posts
            val usuariosPorId = usuarios.associateBy { it.id }
            Feed(
                destaques = usuarios.map { it.toDestaque() },
                postagens = posts.map { it.toPostagem(usuariosPorId[it.userId]) },
            )
        } catch (erro: Exception) {
            Log.e("FeedRepository", "Falha ao recuperar o feed", erro)
            Feed(destaques = emptyList(), postagens = emptyList())
        }
}
