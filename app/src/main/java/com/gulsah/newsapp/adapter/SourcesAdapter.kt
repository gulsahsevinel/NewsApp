package com.gulsah.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.newsapp.databinding.CardViewSourcesBinding
import com.gulsah.newsapp.model.Sources
import com.gulsah.newsapp.view.SourcesFragmentDirections
import com.gulsah.newsapp.viewModel.SourcesViewModel

class SourcesAdapter(var sourceslist: List<Sources>, var viewModel: SourcesViewModel) :
    RecyclerView.Adapter<SourcesAdapter.SourcesCardHolder>() {
    inner class SourcesCardHolder(cardViewSourcesBinding: CardViewSourcesBinding) :
        RecyclerView.ViewHolder(cardViewSourcesBinding.root) {
        var cardView: CardViewSourcesBinding

        init {
            this.cardView = cardViewSourcesBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesCardHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = CardViewSourcesBinding.inflate(layoutInflater, parent, false)
        return SourcesCardHolder(layout)
    }

    override fun onBindViewHolder(holder: SourcesCardHolder, position: Int) {
        val source = sourceslist.get(position)
        holder.cardView.sourcesObject = source

        holder.cardView.cardViewSources.setOnClickListener {
            val transition = SourcesFragmentDirections.sourcesToTopHeadlines((source))
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return sourceslist.size
    }

}