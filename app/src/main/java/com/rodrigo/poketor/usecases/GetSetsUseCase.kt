package com.rodrigo.poketor.usecases

import com.rodrigo.poketor.data.PoketorRepository
import com.rodrigo.poketor.data.dto.SetDto
import com.rodrigo.poketor.data.dto.SetsListDto
import javax.inject.Inject

class GetSetsUseCase @Inject constructor(private val repo: PoketorRepository) {
    suspend operator fun invoke(): Result<List<SetDto>>{
        val res = repo.getSets()
        return res.map { it.data }
    }
}