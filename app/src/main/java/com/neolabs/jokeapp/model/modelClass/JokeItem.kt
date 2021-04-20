package com.neolabs.jokeapp.model.modelClass

import com.google.gson.annotations.SerializedName



data class JokeItem(
        @SerializedName("id")
        val id: Int,
        @SerializedName("punchline")
        val punchline: String,
        @SerializedName("setup")
        val setup: String,
        @SerializedName("type")
        val type: String
)