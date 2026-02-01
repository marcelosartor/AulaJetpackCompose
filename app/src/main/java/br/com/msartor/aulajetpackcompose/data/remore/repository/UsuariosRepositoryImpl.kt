package br.com.msartor.aulajetpackcompose.data.remore.repository

import br.com.msartor.aulajetpackcompose.data.remore.api.DummyApi
import br.com.msartor.aulajetpackcompose.data.remore.dto.User
import javax.inject.Inject

class UsuariosRepositoryImpl
@Inject
constructor(private val dummyApi: DummyApi) : IUsuariosRepository
{
    override suspend fun recuperarUsuarios(): List<User> {
        try {
            val resposta = dummyApi.recuperarUsuarios()
            if (resposta.isSuccessful) {
                return resposta.body()?.users ?: emptyList()
            }

        }catch (erroRequisição: Exception){
            erroRequisição.stackTraceToString()
        }
        return emptyList()
    }
}