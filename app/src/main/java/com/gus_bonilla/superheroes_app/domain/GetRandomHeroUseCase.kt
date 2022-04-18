package com.gus_bonilla.superheroes_app.domain

import com.gus_bonilla.superheroes_app.data.model.HeroModel
import com.gus_bonilla.superheroes_app.data.model.HeroProvider

class GetRandomHeroUseCase {
    operator fun invoke():HeroModel?{
        val heroes:List<HeroModel> = HeroProvider.heroes

        return if(!heroes.isNullOrEmpty()){
            val randomIdx:Int = (heroes.indices).random()
            heroes[randomIdx]
        } else null
    }
}