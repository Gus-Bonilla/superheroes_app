package com.gus_bonilla.superheroes_app.domain

import com.gus_bonilla.superheroes_app.data.HeroRepository
import com.gus_bonilla.superheroes_app.data.model.HeroModel

class GetMoreHeroesUseCase {
    private val repository = HeroRepository()

    suspend operator fun invoke(offset: Int): List<HeroModel>? = repository.getMoreHeroes(offset)
}