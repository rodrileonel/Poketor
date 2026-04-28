package com.rodrigo.poketor.core.fixtures

import com.rodrigo.poketor.core.fixtures.dto.SetDto
import com.rodrigo.poketor.core.fixtures.dto.SetImageDto

object SetFixtures {
    fun ascended() = SetDto(
        "me2pt5",
        "Ascended Heroes",
        "Mega Evolution",
        "2026/01/30",
        SetImageDto(
            "https://images.scrydex.com/pokemon/me2pt5-symbol/symbol",
            "https://images.scrydex.com/pokemon/me2pt5-logo/logo"
        )
    )
}