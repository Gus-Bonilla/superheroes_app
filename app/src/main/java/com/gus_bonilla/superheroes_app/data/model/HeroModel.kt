package com.gus_bonilla.superheroes_app.data.model

import com.google.gson.annotations.SerializedName

data class HeroModel (@SerializedName("id") val heroId:Int,
                      @SerializedName("name") val heroName:String,
                      @SerializedName("description") val heroDescription:String)