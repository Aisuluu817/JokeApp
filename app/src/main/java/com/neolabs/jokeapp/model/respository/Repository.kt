package com.neolabs.jokeapp.model.respository

import android.util.Log
import com.neolabs.jokeapp.contract.Contract
import com.neolabs.jokeapp.model.modelClass.JokeItem
import com.neolabs.jokeapp.api.RetrofitInstance
import com.neolabs.jokeapp.presenter.JokePresenter
import retrofit2.Callback
import retrofit2.Response


class Repository : Contract.Model{

    private var  jokesList : ArrayList<JokeItem>? = null


    override fun getJokes(presenter: JokePresenter) {
        val call = RetrofitInstance.api.getJokes()
        call.enqueue(object: Callback<ArrayList<JokeItem>> {
            override fun onFailure(call: retrofit2.Call<ArrayList<JokeItem>>, t: Throwable) {
                Log.e("failed", t.message.toString())
            }

            override fun onResponse(
                call: retrofit2.Call<ArrayList<JokeItem>>,
                response: Response<ArrayList<JokeItem>>
            ) {
                if (response.isSuccessful){
                    jokesList = response.body()
                    jokesList?.let { presenter.uiAutoUpdate(it) }
                }
            }
        })

    }

}