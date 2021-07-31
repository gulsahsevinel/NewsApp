package com.gulsah.newsapp.adapter


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.newsapp.R
import com.gulsah.newsapp.databinding.CardViewTopHeadlinesBinding
import com.gulsah.newsapp.model.Articles
import com.squareup.picasso.Picasso


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
        val url = topHeadline.url

        Picasso.get().load(topHeadline.urlToImage).into(holder.cardView.imageViewTopHeadlines)

        holder.cardView.imageButtonFavorite.setOnClickListener {
            holder.cardView.imageButtonFavorite.setImageResource(R.drawable.ic_baseline_bookmark)
        }
        holder.cardView.cardViewTopHeadlines.setOnClickListener() {
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return topHeadlinesList.size
        Log.e("size", topHeadlinesList.size.toString())
    }
}