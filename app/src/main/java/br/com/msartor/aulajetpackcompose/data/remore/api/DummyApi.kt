package br.com.msartor.aulajetpackcompose.data.remore.api

import br.com.msartor.aulajetpackcompose.data.remore.dto.UsuarioResultado
import retrofit2.Response
import retrofit2.http.GET

interface DummyApi {
    @GET("users")
    suspend fun recuperarUsuarios() : Response<UsuarioResultado>
}