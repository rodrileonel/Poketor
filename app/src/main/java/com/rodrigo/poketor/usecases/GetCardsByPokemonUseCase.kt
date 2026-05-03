package com.rodrigo.poketor.usecases

import com.rodrigo.poketor.core.fixtures.dto.CardDto
import com.rodrigo.poketor.data.PoketorRepository
import javax.inject.Inject

class GetCardsByPokemonUseCase @Inject constructor (private val repo: PoketorRepository) {
    suspend operator fun invoke(filter:String): Result<List<CardDto>>{
        val res = repo.getCards("name:$filter")
        return res.map { it.data }
    }
}