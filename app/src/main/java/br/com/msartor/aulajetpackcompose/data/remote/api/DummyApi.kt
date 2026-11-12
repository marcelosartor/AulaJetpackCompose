package br.com.msartor.aulajetpackcompose.data.remote.api

import br.com.msartor.aulajetpackcompose.data.remote.dto.PostsResponse
import br.com.msartor.aulajetpackcompose.data.remote.dto.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyApi {
    @GET("users")
    suspend fun recuperarUsuarios(
        @Query("limit") limite: Int = 20,
        @Query("select") campos: String = "id,firstName,image",
    ): UsersResponse

    @GET("posts")
    suspend fun recuperarPostagens(
        @Query("limit") limite: Int = 20,
    ): PostsResponse
}
