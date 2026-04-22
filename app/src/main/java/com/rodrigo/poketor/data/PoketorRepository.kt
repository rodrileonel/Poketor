package com.rodrigo.poketor.data

import com.rodrigo.poketor.data.dto.SetsListDto
import javax.inject.Inject

interface PoketorRepository {
    suspend fun getSets(): Result<SetsListDto>
}

class PoketorRepositoryImpl @Inject constructor(
    private val api: PoketorApi
): PoketorRepository {
    override suspend fun getSets(): Result<SetsListDto> {
        return try {
            val response = api.getSets()
            Result.success(response)
        } catch (e: Exception){
            Result.failure(e)
        }
    }

}