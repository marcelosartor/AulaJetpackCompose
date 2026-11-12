package br.com.msartor.aulajetpackcompose.data.remote.repository

import br.com.msartor.aulajetpackcompose.data.remote.model.Feed

interface FeedRepository {
    suspend fun recuperarFeed(): Result<Feed>
}
