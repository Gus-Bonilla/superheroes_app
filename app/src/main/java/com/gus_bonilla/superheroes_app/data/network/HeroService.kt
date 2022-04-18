package com.gus_bonilla.superheroes_app.data.network

import com.gus_bonilla.superheroes_app.core.RetrofitHelper
import com.gus_bonilla.superheroes_app.data.model.HeroesBlockModel
import com.gus_bonilla.superheroes_app.data.model.HeroesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class HeroService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getHeroes() : HeroesBlockModel{
        return withContext(Dispatchers.IO){
            val response : Response<HeroesBlockModel> = retrofit.create(HeroApiClient::class.java).getNewHeroes()
            response.body() ?: HeroesBlockModel(status="failed", attributionText="",
                rawHeroes=HeroesModel(blockOffset=0, totalHeroes=0, heroesCount=0, heroes= emptyList()))
        }
    }
}