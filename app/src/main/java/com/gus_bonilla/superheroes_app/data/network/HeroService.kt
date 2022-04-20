package com.gus_bonilla.superheroes_app.data.network

import android.util.Log
import com.gus_bonilla.superheroes_app.core.RetrofitHelper
import com.gus_bonilla.superheroes_app.data.model.HeroesBlockModel
import com.gus_bonilla.superheroes_app.data.model.HeroesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class HeroService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getHeroes(): HeroesBlockModel{
        return withContext(Dispatchers.IO){
            val response: Response<HeroesBlockModel> = retrofit.create(HeroApiClient::class.java).getNewHeroes()
            response.body()?: HeroesBlockModel(status="failed", attributionText="",
                rawHeroes=HeroesModel(blockOffset=0, totalHeroes=0, heroesCount=0, heroes= emptyList()))
        }
    }

    suspend fun getMoreHeroes(offset: Int): HeroesBlockModel{
        return withContext(Dispatchers.IO){
            val response: Response<HeroesBlockModel> = retrofit
                .create(HeroApiClient::class.java)
                .getMoreHeroes("name", "40", offset.toString(), "1",
                    "bba91db5f9c6865d7e903f5391dca74b", "c7ebb8b5440c9fdd1070dfd8899c9d64")

            //Log.d("TAG", response.toString())

            response.body() ?: HeroesBlockModel(status="failed", attributionText="",
                rawHeroes=HeroesModel(blockOffset=0, totalHeroes=0, heroesCount=0, heroes= emptyList()))
        }
    }
}