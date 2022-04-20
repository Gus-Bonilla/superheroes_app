package com.gus_bonilla.superheroes_app.data.network

import com.gus_bonilla.superheroes_app.data.model.HeroesBlockModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroApiClient {
    @GET("v1/public/characters?orderBy=name&limit=40&ts=1&apikey=bba91db5f9c6865d7e903f5391dca74b&hash=c7ebb8b5440c9fdd1070dfd8899c9d64")
    suspend fun getNewHeroes(): Response<HeroesBlockModel>

    @GET("v1/public/characters")
    suspend fun getMoreHeroes(
        @Query("orderBy") orderedBy: String,
        @Query("limit") limit: String,
        @Query("offset") offset: String,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<HeroesBlockModel>
}