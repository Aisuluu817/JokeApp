package com.neolabs.jokeapp.presenter

import com.neolabs.jokeapp.contract.Contract
import com.neolabs.jokeapp.model.modelClass.JokeItem
import com.neolabs.jokeapp.model.respository.Repository

class JokePresenter(view : Contract.View) : Contract.Presenter{
    private var view: Contract.View = view
    private var model : Contract.Model = Repository()

    override fun uiAutoUpdate( jokesList: ArrayList<JokeItem>){
            view.updateViewData(jokesList)
    }

    override fun networkCall() {
        model.getJokes(this)

    }


}