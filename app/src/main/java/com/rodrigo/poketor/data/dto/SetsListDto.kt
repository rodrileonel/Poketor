package com.rodrigo.poketor.data.dto

data class SetsListDto (
    val data: List<SetDto>,
    val page: Long,
    val pageSize: Long,
    val count: Long,
    val totalCount: Long
)

data class SetDto (
    val id: String,
    val name: String,
    val series: String,
    val releaseDate: String,
    val images: SetImageDto
)

data class SetImageDto (
    val symbol: String,
    val logo: String
)
