package com.neolabs.jokeapp.contract

import com.neolabs.jokeapp.model.modelClass.JokeItem
import com.neolabs.jokeapp.presenter.JokePresenter

interface Contract {
    interface Model{
        fun getJokes(presenter: JokePresenter)
    }
    interface View{
        fun updateViewData(jokesList: ArrayList<JokeItem>)
    }
    interface Presenter{
        fun uiAutoUpdate(jokesList : ArrayList<JokeItem>)
        fun networkCall()
    }
}