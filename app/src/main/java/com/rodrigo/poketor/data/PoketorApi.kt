package com.rodrigo.poketor.data

import com.rodrigo.poketor.data.dto.SetsListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PoketorApi {
    @GET("sets")
    suspend fun getSets(
        @Query("select") select:String = ApiConstants.SETS_SELECT,
        @Query("orderBy") orderBy:String = ApiConstants.SETS_ORDER,
        @Query("pageSize") pageSize:Int = 250,
        @Query("page") page:Int = 1
    ): SetsListDto
}