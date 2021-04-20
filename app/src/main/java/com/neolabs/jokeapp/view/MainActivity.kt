package com.neolabs.jokeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.neolabs.jokeapp.contract.Contract
import com.neolabs.jokeapp.R
import com.neolabs.jokeapp.adapter.JokesAdapter
import com.neolabs.jokeapp.model.modelClass.JokeItem
import com.neolabs.jokeapp.presenter.JokePresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.recycler_view


class MainActivity : AppCompatActivity(), Contract.View {
    lateinit var adapter: JokesAdapter
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var presenter: JokePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        progress_bar.visibility = View.VISIBLE
        presenter = JokePresenter(this)
        setView()

        handler = Handler()
        swipe_refresher.setOnRefreshListener {
            runnable = Runnable{
                setView()
                swipe_refresher.isRefreshing = false
            }
            handler.postDelayed(
                runnable, 2500.toLong()
            )
            }
        }

    private fun setView() {
        presenter.networkCall()
    }

    override fun updateViewData(jokesList: ArrayList<JokeItem>) {
        progress_bar.visibility = View.INVISIBLE
        adapter = JokesAdapter()
        adapter.differ.submitList(jokesList)
        recycler_view.adapter = adapter
        recycler_view.startLayoutAnimation()
    }


}