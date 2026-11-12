package br.com.msartor.aulajetpackcompose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.msartor.aulajetpackcompose.data.remote.model.Destaque
import br.com.msartor.aulajetpackcompose.data.remote.model.Postagem
import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme
import br.com.msartor.aulajetpackcompose.ui.view.Home
import br.com.msartor.aulajetpackcompose.ui.view.HomeUiState
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeTest {

    @get:Rule
    val composeRule = createComposeRule()

    private fun mostrar(estado: HomeUiState, aoTentarNovamente: () -> Unit = {}) {
        composeRule.setContent {
            AulaJetpackComposeTheme { Home(estado, aoTentarNovamente) }
        }
    }

    @Test
    fun sucessoMostraDestaquesEPostagens() {
        mostrar(
            HomeUiState.Sucesso(
                destaques = listOf(Destaque(1, "Ana", "")),
                postagens = listOf(Postagem(1, "Bruno", "", "", "Minha postagem")),
            )
        )

        composeRule.onNodeWithText("Ana").assertIsDisplayed()
        composeRule.onNodeWithText("Bruno").assertIsDisplayed()
        composeRule.onNodeWithText("Minha postagem").assertIsDisplayed()
    }

    @Test
    fun erroMostraMensagemEDisparaNovaTentativa() {
        var tentou = false
        mostrar(HomeUiState.Erro("Sem conexão")) { tentou = true }

        composeRule.onNodeWithText("Sem conexão").assertIsDisplayed()
        composeRule.onNodeWithText("Tentar novamente").performClick()

        assertTrue(tentou)
    }
}
