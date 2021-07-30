package com.gulsah.newsapp.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.newsapp.databinding.CardViewTopHeadlinesBinding
import com.gulsah.newsapp.model.Articles


class TopHeadlinesAdapter(
    var topHeadlinesList: List<Articles>,
) :
    RecyclerView.Adapter<TopHeadlinesAdapter.TopHeadlinesCardHolder>() {
    inner class TopHeadlinesCardHolder(cardViewTopHeadlinesBinding: CardViewTopHeadlinesBinding) :
        RecyclerView.ViewHolder(cardViewTopHeadlinesBinding.root) {
        var cardView: CardViewTopHeadlinesBinding

        init {
            this.cardView = cardViewTopHeadlinesBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesCardHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = CardViewTopHeadlinesBinding.inflate(layoutInflater, parent, false)
        return TopHeadlinesCardHolder(layout)
    }

    override fun onBindViewHolder(holder: TopHeadlinesCardHolder, position: Int) {
        val topHeadline = topHeadlinesList.get(position)
        holder.cardView.headlinesObject = topHeadline


    }

    override fun getItemCount(): Int {
        return topHeadlinesList.size
        Log.e("size",topHeadlinesList.size.toString())
    }
}