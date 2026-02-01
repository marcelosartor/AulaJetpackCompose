package br.com.msartor.aulajetpackcompose.di

import br.com.msartor.aulajetpackcompose.data.remore.api.DummyApi
import br.com.msartor.aulajetpackcompose.data.remore.repository.IUsuariosRepository
import br.com.msartor.aulajetpackcompose.data.remore.repository.UsuariosRepositoryImpl
import br.com.msartor.aulajetpackcompose.utils.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providerDummuApi(retrofit: Retrofit): DummyApi {
        return retrofit.create(DummyApi::class.java)

    }

    @Provides
    fun providerUsuarioRepository(dummyApi:DummyApi): IUsuariosRepository {
        return UsuariosRepositoryImpl(dummyApi)
    }
}