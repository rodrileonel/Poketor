package com.rodrigo.poketor.core.fixtures

import com.rodrigo.poketor.core.fixtures.dto.CardDto
import com.rodrigo.poketor.core.fixtures.dto.CardImageDto
import com.rodrigo.poketor.core.fixtures.dto.CardsListDto
import com.rodrigo.poketor.core.fixtures.dto.SetDto
import com.rodrigo.poketor.core.fixtures.dto.SetImageDto
import com.rodrigo.poketor.core.fixtures.dto.TCGPlayerDto
import com.rodrigo.poketor.core.fixtures.dto.TCGPlayerPricesDto
import com.rodrigo.poketor.core.fixtures.dto.TCGPlayerPricesHolofoilDto

object CardFixtures {
    fun pinsir() = CardsListDto(
        data = listOf(
            CardDto(
                id = "sv8pt5-3",
                name = "Pinsir",
                set = SetDto(
                    id = "sv8pt5",
                    name = "Prismatic Evolutions",
                    series = "Scarlet & Violet",
                    releaseDate = "2025/01/17",
                    images = SetImageDto(
                        symbol = "https://images.pokemontcg.io/sv8pt5/symbol.png",
                        logo = "https://images.pokemontcg.io/sv8pt5/logo.png"
                    )
                ),
                number = "3",
                images = CardImageDto(
                    small = "https://images.pokemontcg.io/sv8pt5/3.png",
                    large = "https://images.pokemontcg.io/sv8pt5/3_hires.png"
                ),
                tcgplayer = TCGPlayerDto(
                    url = "https://prices.pokemontcg.io/tcgplayer/sv8pt5-3",
                    updatedAt = "2026/04/28",
                    prices = TCGPlayerPricesDto(
                        reverseHolofoil = TCGPlayerPricesHolofoilDto(
                            low = 0.01,
                            mid = 0.15,
                            high = 999.0,
                            market = 0.1,
                            directLow = 0.01
                        ),
                        normal = TCGPlayerPricesHolofoilDto(
                            low = 0.01,
                            mid = 0.1,
                            high = 999.0,
                            market = 0.03,
                            directLow = 0.01
                        )
                    )
                )
            )
        ),
        page = 1,
        pageSize = 1,
        count = 1,
        totalCount = 1
    )
}