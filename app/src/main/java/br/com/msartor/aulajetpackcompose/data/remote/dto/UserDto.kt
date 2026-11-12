package br.com.msartor.aulajetpackcompose.data.remote.dto

data class UserDto(
    val id: Int,
    val firstName: String,
    val image: String,
)

data class UsersResponse(
    val users: List<UserDto>,
)
