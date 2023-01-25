package com.example.myapitestinfifa

import com.google.gson.annotations.SerializedName

data class FifaApi(
    @SerializedName("accessId") val accessId: String,
    @SerializedName("level") val level: Int,
    @SerializedName("nickname") val nickname: String
)