package br.com.msartor.aulajetpackcompose

import br.com.msartor.aulajetpackcompose.data.remote.dto.PostDto
import br.com.msartor.aulajetpackcompose.data.remote.dto.UserDto
import br.com.msartor.aulajetpackcompose.data.remote.repository.toDestaque
import br.com.msartor.aulajetpackcompose.data.remote.repository.toPostagem
import org.junit.Assert.assertEquals
import org.junit.Test

class MappersTest {

    private val usuario = UserDto(id = 7, firstName = "Ana", image = "http://img/ana.png")

    @Test
    fun `mapeia UserDto para Destaque`() {
        val destaque = usuario.toDestaque()

        assertEquals(7, destaque.id)
        assertEquals("Ana", destaque.nome)
        assertEquals("http://img/ana.png", destaque.imagemPerfilUrl)
    }

    @Test
    fun `mapeia PostDto para Postagem com dados do autor`() {
        val postagem = PostDto(id = 3, title = "t", body = "texto", userId = 7).toPostagem(usuario)

        assertEquals(3, postagem.id)
        assertEquals("Ana", postagem.nome)
        assertEquals("http://img/ana.png", postagem.imagemPerfilUrl)
        assertEquals("texto", postagem.descricao)
    }

    @Test
    fun `autor desconhecido gera postagem sem nome`() {
        val postagem = PostDto(id = 3, title = "t", body = "texto", userId = 99).toPostagem(null)

        assertEquals("", postagem.nome)
    }
}
