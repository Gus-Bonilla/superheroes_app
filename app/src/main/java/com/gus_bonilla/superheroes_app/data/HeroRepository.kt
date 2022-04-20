package com.gus_bonilla.superheroes_app.data

import android.util.Log
import com.gus_bonilla.superheroes_app.data.model.HeroModel
import com.gus_bonilla.superheroes_app.data.model.HeroProvider
import com.gus_bonilla.superheroes_app.data.model.HeroesBlockModel
import com.gus_bonilla.superheroes_app.data.network.HeroService
import org.apache.commons.collections4.ListUtils

class HeroRepository {
    private val api = HeroService()

    suspend fun getNewHeroes() : List<HeroModel>{
        val response: HeroesBlockModel = api.getHeroes()
        val heroesList: List<HeroModel> = response.rawHeroes.heroes

        //if(response.status == "ok")

        HeroProvider.heroes = heroesList
        return heroesList
    }

    suspend fun getMoreHeroes(offset: Int) : List<HeroModel>{
        val response: HeroesBlockModel = api.getMoreHeroes(offset)
        val heroesList: List<HeroModel> = response.rawHeroes.heroes

        //if(heroesList.isNullOrEmpty()) Log.d("TAG", response.status)
        //if(response.status == "ok")

        HeroProvider.heroes = ListUtils.union(HeroProvider.heroes, heroesList)
        return heroesList
    }
}