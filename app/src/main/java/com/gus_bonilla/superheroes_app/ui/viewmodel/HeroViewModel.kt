package com.gus_bonilla.superheroes_app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gus_bonilla.superheroes_app.data.model.HeroModel
import com.gus_bonilla.superheroes_app.domain.GetHeroesUseCase
import com.gus_bonilla.superheroes_app.domain.GetRandomHeroUseCase
import kotlinx.coroutines.launch

class HeroViewModel : ViewModel() {
    val heroModel = MutableLiveData<HeroModel>()
    val isLoading = MutableLiveData<Boolean>()
    var getHeroesUseCase = GetHeroesUseCase()
    var getRandomHeroUseCase = GetRandomHeroUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<HeroModel>? = getHeroesUseCase()

            if(!result.isNullOrEmpty()){
                heroModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomHero(){
        isLoading.postValue(true)

        val hero:HeroModel? = getRandomHeroUseCase()

        if(hero!=null) heroModel.postValue(hero!!)

        isLoading.postValue(false)
    }
}