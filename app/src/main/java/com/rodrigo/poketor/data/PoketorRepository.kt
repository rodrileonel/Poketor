package com.rodrigo.poketor.data

import com.rodrigo.poketor.core.fixtures.dto.CardsListDto
import com.rodrigo.poketor.core.fixtures.dto.SetsListDto
import javax.inject.Inject

interface PoketorRepository {
    suspend fun getSets(): Result<SetsListDto>
    suspend fun getCards(filter:String): Result<CardsListDto>
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

    override suspend fun getCards(filter: String): Result<CardsListDto> {
        return try {
            val response = api.getCards(filter)
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }

}