package com.rodrigo.poketor.usecases

import com.rodrigo.poketor.core.fixtures.dto.CardDto
import com.rodrigo.poketor.data.PoketorRepository
import javax.inject.Inject

class GetCardsBySetUseCase @Inject constructor (private val repo: PoketorRepository) {
    suspend operator fun invoke(filter:String): Result<List<CardDto>>{
        val res = repo.getCards("set.id:$filter")
        return res.map { response ->
            response.data.sortedBy {
                it.number.toIntOrNull()?:Int.MAX_VALUE
            }
        }
    }
}