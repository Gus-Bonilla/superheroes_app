package com.gus_bonilla.superheroes_app.data.model

import com.google.gson.annotations.SerializedName

data class HeroesModel(@SerializedName("offset") val blockOffset:Int,
                       @SerializedName("total") val totalHeroes:Int,
                       @SerializedName("count") val heroesCount:Int,
                       @SerializedName("results") val heroes:List<HeroModel>)
