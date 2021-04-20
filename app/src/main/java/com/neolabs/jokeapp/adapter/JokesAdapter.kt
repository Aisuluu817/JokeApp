package com.neolabs.jokeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.neolabs.jokeapp.R
import com.neolabs.jokeapp.model.modelClass.JokeItem
import kotlinx.android.synthetic.main.list_item.view.*

class JokesAdapter : RecyclerView.Adapter<JokesAdapter.JokesViewHolder>(){
    class JokesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
      private val differCallback = object : DiffUtil.ItemCallback<JokeItem>(){
          override fun areItemsTheSame(oldItem: JokeItem, newItem: JokeItem): Boolean {
              return oldItem.id == newItem.id
          }
          override fun areContentsTheSame(oldItem: JokeItem, newItem: JokeItem): Boolean {
              return oldItem == newItem
          }
    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesAdapter.JokesViewHolder {
        return JokesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: JokesAdapter.JokesViewHolder, position: Int) {
        val joke = differ.currentList[position]
            holder.itemView.apply {
                holder.itemView.type.text = joke.type
                if (holder.itemView.type.text.equals("general")){
                    holder.itemView.type.setBackgroundResource(R.drawable.ic_type_general)
                }
                if (holder.itemView.type.text.equals("programming")){
                    holder.itemView.type.setBackgroundResource(R.drawable.ic_type_programming)
                }
                if (holder.itemView.type.text.equals("knock-knock")){
                    holder.itemView.type.setBackgroundResource(R.drawable.ic_type_knock)
                }

                holder.itemView.setup.text = joke.setup

                holder.itemView.punchline.text = joke.punchline
            }
        holder.itemView.setOnClickListener {
            holder.itemView.punchline.visibility = View.VISIBLE
        }
    }

}