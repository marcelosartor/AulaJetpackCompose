package br.com.msartor.aulajetpackcompose.data.remote.repository

import br.com.msartor.aulajetpackcompose.data.remote.api.DummyApi
import br.com.msartor.aulajetpackcompose.data.remote.model.Feed
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val dummyApi: DummyApi,
) : FeedRepository {

    override suspend fun recuperarFeed(): Result<Feed> =
        try {
            val usuarios = dummyApi.recuperarUsuarios().users
            val posts = dummyApi.recuperarPostagens().posts
            val usuariosPorId = usuarios.associateBy { it.id }
            Result.success(
                Feed(
                    destaques = usuarios.map { it.toDestaque() },
                    postagens = posts.map { it.toPostagem(usuariosPorId[it.userId]) },
                )
            )
        } catch (cancelamento: CancellationException) {
            throw cancelamento
        } catch (erro: Exception) {
            Result.failure(erro)
        }
}
