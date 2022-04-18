package com.gus_bonilla.superheroes_app.data.model

import com.google.gson.annotations.SerializedName

data class ImageModel(@SerializedName("path") val heroImagePath:String,
                      @SerializedName("extension") val heroImageExt:String)
