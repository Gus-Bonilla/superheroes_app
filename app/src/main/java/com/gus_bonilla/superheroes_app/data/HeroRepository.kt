package com.gus_bonilla.superheroes_app.data

import com.gus_bonilla.superheroes_app.data.model.HeroModel
import com.gus_bonilla.superheroes_app.data.model.HeroProvider
import com.gus_bonilla.superheroes_app.data.model.HeroesBlockModel
import com.gus_bonilla.superheroes_app.data.network.HeroService

class HeroRepository {
    private val api = HeroService()

    suspend fun getNewHeroes() : List<HeroModel>{
        val response : HeroesBlockModel = api.getHeroes()
        val heroesList : List<HeroModel> = response.rawHeroes.heroes

        //if(response.status == "ok")

        HeroProvider.heroes = heroesList
        return heroesList
    }
}