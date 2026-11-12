package br.com.msartor.aulajetpackcompose.di

import br.com.msartor.aulajetpackcompose.data.remote.api.DummyApi
import br.com.msartor.aulajetpackcompose.data.remote.repository.FeedRepository
import br.com.msartor.aulajetpackcompose.data.remote.repository.FeedRepositoryImpl
import br.com.msartor.aulajetpackcompose.utils.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideDummyApi(retrofit: Retrofit): DummyApi =
        retrofit.create(DummyApi::class.java)

    @Provides
    @Singleton
    fun provideFeedRepository(dummyApi: DummyApi): FeedRepository =
        FeedRepositoryImpl(dummyApi)
}
