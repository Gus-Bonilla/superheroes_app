package com.gus_bonilla.superheroes_app.data.model

import com.google.gson.annotations.SerializedName

data class HeroesBlockModel(@SerializedName("status") val status:String,
                            @SerializedName("attributionText") val attributionText:String,
                            @SerializedName("data") val rawHeroes: HeroesModel)
