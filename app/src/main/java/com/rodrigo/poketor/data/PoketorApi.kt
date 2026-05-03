package com.rodrigo.poketor.data

import com.rodrigo.poketor.core.fixtures.dto.CardsListDto
import com.rodrigo.poketor.core.fixtures.dto.SetsListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PoketorApi {
    @GET("sets")
    suspend fun getSets(
        @Query("select") select:String = ApiConstants.SETS_SELECT,
        @Query("orderBy") orderBy:String = ApiConstants.SETS_ORDER,
    ): SetsListDto

    @GET("cards")
    suspend fun getCards(
        @Query("q") filter:String,
        @Query("select") select:String = ApiConstants.CARDS_SELECT
    ): CardsListDto
}