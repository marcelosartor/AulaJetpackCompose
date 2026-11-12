package br.com.msartor.aulajetpackcompose

import br.com.msartor.aulajetpackcompose.data.remote.model.Destaque
import br.com.msartor.aulajetpackcompose.data.remote.model.Feed
import br.com.msartor.aulajetpackcompose.data.remote.repository.FeedRepository
import br.com.msartor.aulajetpackcompose.ui.view.HomeUiState
import br.com.msartor.aulajetpackcompose.viewmodel.FeedViewModel
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FeedViewModelTest {

    private class RepositorioFalso(
        var resposta: CompletableDeferred<Result<Feed>> = CompletableDeferred(),
    ) : FeedRepository {
        var chamadas = 0
        override suspend fun recuperarFeed(): Result<Feed> {
            chamadas++
            return resposta.await()
        }
    }

    private val feed = Feed(listOf(Destaque(1, "Ana", "")), emptyList())

    @Before
    fun setUp() = Dispatchers.setMain(UnconfinedTestDispatcher())

    @After
    fun tearDown() = Dispatchers.resetMain()

    @Test
    fun `comeca carregando e carrega uma unica vez no init`() {
        val repo = RepositorioFalso()
        val viewModel = FeedViewModel(repo)

        assertEquals(HomeUiState.Carregando, viewModel.uiState.value)
        assertEquals(1, repo.chamadas)
    }

    @Test
    fun `emite sucesso quando o repositorio responde`() {
        val repo = RepositorioFalso()
        val viewModel = FeedViewModel(repo)

        repo.resposta.complete(Result.success(feed))

        assertEquals(HomeUiState.Sucesso(feed.destaques, feed.postagens), viewModel.uiState.value)
    }

    @Test
    fun `emite erro e permite tentar novamente`() {
        val repo = RepositorioFalso()
        val viewModel = FeedViewModel(repo)
        repo.resposta.complete(Result.failure(RuntimeException("sem rede")))

        assertEquals(HomeUiState.Erro("sem rede"), viewModel.uiState.value)

        repo.resposta = CompletableDeferred(Result.success(feed))
        viewModel.carregarFeed()

        assertTrue(viewModel.uiState.value is HomeUiState.Sucesso)
        assertEquals(2, repo.chamadas)
    }
}
