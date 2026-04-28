package com.rodrigo.poketor.core.fixtures.dto

data class CardsListDto (
    val data: List<CardDto>,
    val page: Long,
    val pageSize: Long,
    val count: Long,
    val totalCount: Long
)

data class CardDto (
    val id: String,
    val name: String,
    val set: SetDto,
    val number: String,
    val images: CardImageDto,
    val tcgplayer: TCGPlayerDto
)

data class CardImageDto (
    val small: String,
    val large: String
)