package com.rodrigo.poketor.core.fixtures.dto

data class TCGPlayerDto (
    val url: String,
    val updatedAt: String,
    val prices: TCGPlayerPricesDto
)

data class TCGPlayerPricesDto (
    val reverseHolofoil: TCGPlayerPricesHolofoilDto? = null,
    val normal: TCGPlayerPricesHolofoilDto? = null,
    val holofoil: TCGPlayerPricesHolofoilDto? = null
)

data class TCGPlayerPricesHolofoilDto (
    val low: Double,
    val mid: Double,
    val high: Double,
    val market: Double,
    val directLow: Double? = null
)