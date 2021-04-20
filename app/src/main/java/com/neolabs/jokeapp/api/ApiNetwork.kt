package com.neolabs.jokeapp.api

import com.neolabs.jokeapp.model.modelClass.JokeItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiNetwork {

       @GET("/random_ten")
        fun getJokes(): Call<ArrayList<JokeItem>>
}