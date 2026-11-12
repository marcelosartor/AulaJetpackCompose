package br.com.msartor.aulajetpackcompose.data.remote.dto

data class PostDto(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int,
)

data class PostsResponse(
    val posts: List<PostDto>,
)
