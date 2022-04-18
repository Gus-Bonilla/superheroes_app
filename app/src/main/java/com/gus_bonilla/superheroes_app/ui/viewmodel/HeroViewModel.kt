package com.gus_bonilla.superheroes_app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gus_bonilla.superheroes_app.R
import com.gus_bonilla.superheroes_app.data.model.HeroModel
import com.gus_bonilla.superheroes_app.data.model.HeroProvider
import com.gus_bonilla.superheroes_app.domain.GetHeroesUseCase
import com.gus_bonilla.superheroes_app.domain.GetRandomHeroUseCase
import com.gus_bonilla.superheroes_app.ui.view.HeroesAdapter
import kotlinx.coroutines.launch

class HeroViewModel : ViewModel() {
    val heroModel = MutableLiveData<HeroModel>()
    val isLoading = MutableLiveData<Boolean>()
    val heroesList = MutableLiveData<List<HeroModel>>()
    var getHeroesUseCase = GetHeroesUseCase()
    var getRandomHeroUseCase = GetRandomHeroUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<HeroModel>? = getHeroesUseCase()

            if(!result.isNullOrEmpty()){
                heroesList.postValue(result!!)
                heroModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun callNewHeroes() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<HeroModel>? = getHeroesUseCase()

            if(!result.isNullOrEmpty()){
                heroesList.postValue(result!!)
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