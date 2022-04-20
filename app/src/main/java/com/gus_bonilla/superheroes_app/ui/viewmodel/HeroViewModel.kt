package com.gus_bonilla.superheroes_app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gus_bonilla.superheroes_app.R
import com.gus_bonilla.superheroes_app.data.model.HeroModel
import com.gus_bonilla.superheroes_app.data.model.HeroProvider
import com.gus_bonilla.superheroes_app.domain.GetHeroesUseCase
import com.gus_bonilla.superheroes_app.domain.GetMoreHeroesUseCase
import com.gus_bonilla.superheroes_app.domain.GetRandomHeroUseCase
import com.gus_bonilla.superheroes_app.ui.view.HeroesAdapter
import kotlinx.coroutines.launch
import org.apache.commons.collections4.ListUtils

class HeroViewModel : ViewModel() {
    val heroModel = MutableLiveData<HeroModel>()
    val isLoading = MutableLiveData<Boolean>()
    val heroesList = MutableLiveData<List<HeroModel>>()
    var getHeroesUseCase = GetHeroesUseCase()
    var getRandomHeroUseCase = GetRandomHeroUseCase()
    var getMoreHeroesUseCase = GetMoreHeroesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<HeroModel>? = getHeroesUseCase()

            if(!result.isNullOrEmpty()){
                heroesList.postValue(result!!)
                heroModel.postValue(result[0])
            }

            isLoading.postValue(false)
        }
    }

    fun getMoreHeroes(offset: Int) {
        viewModelScope.launch {
            isLoading.postValue(true) // Change the progress bar for this
            val result: List<HeroModel>? = getMoreHeroesUseCase(offset)

            if(!result.isNullOrEmpty()){
                //Log.d("TAG", "Result is not empty :)")
                var fullResult: List<HeroModel> = ListUtils.union(heroesList.value, result)

                heroesList.postValue(fullResult)
            }

            isLoading.postValue(false) // Change the progress bar for this
        }
    }

    fun randomHero(){
        isLoading.postValue(true)

        val hero:HeroModel? = getRandomHeroUseCase()

        if(hero!=null) heroModel.postValue(hero!!)

        isLoading.postValue(false)
    }
}