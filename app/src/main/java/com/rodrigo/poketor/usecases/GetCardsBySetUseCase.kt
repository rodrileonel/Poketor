package com.rodrigo.poketor.usecases

import com.rodrigo.poketor.core.fixtures.dto.CardDto
import com.rodrigo.poketor.data.PoketorRepository
import javax.inject.Inject

class GetCardsBySetUseCase @Inject constructor (private val repo: PoketorRepository) {
    suspend operator fun invoke(filter:String): Result<List<CardDto>>{

        val allCards = mutableListOf<CardDto>()
        var page = 1
        val pageSize = 250

        while (true) {
            val res = repo.getCards(
                filter = "set.id:$filter",
                page = page,
                pageSize = pageSize
            ).getOrElse { error ->
                return Result.failure(error)
            }
            allCards.addAll(res.data)
            if (allCards.size>=res.totalCount) break
            page++
        }

        return Result.success(
            allCards.sortedBy {
                it.number.toIntOrNull() ?: Int.MAX_VALUE
            }
        )
    }
}