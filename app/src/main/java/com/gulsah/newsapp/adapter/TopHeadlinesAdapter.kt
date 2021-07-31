package com.gulsah.newsapp.adapter


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.newsapp.R
import com.gulsah.newsapp.databinding.CardViewTopHeadlinesBinding
import com.gulsah.newsapp.model.Articles
import com.gulsah.newsapp.roomdb.ArticlesDao
import com.gulsah.newsapp.view.TopHeadlinesFragment
import com.gulsah.newsapp.viewModel.TopHeadlinesViewModel
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class TopHeadlinesAdapter(
    var topHeadlinesList: List<Articles>,
    var articlesDao: ArticlesDao,
    var compositeDisposable: CompositeDisposable,
    var view: View,
    var viewModel: TopHeadlinesViewModel
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
        val url = topHeadline.url
        Picasso.get().load(topHeadline.urlToImage).into(holder.cardView.imageViewTopHeadlines)
        holder.cardView.headlinesObject = topHeadline


        //adding bookmarks
        holder.cardView.imageButtonFavorite.setOnClickListener {
            if (topHeadline.bookmarkStatus == 1) {
                compositeDisposable.add(
                    articlesDao.delete(topHeadline).subscribeOn(
                        Schedulers.io()
                    ).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::handleResponseDelete)
                )
                holder.cardView.imageButtonFavorite.setImageResource(R.drawable.ic_baseline_bookmark_border)
                viewModel.allTopHeadlines
            } else {
                topHeadline.bookmarkStatus = 1
                compositeDisposable.add(
                    articlesDao.insert(topHeadline).subscribeOn(
                        Schedulers.io()
                    ).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResponseAdd)
                )
                holder.cardView.imageButtonFavorite.setImageResource(R.drawable.ic_baseline_bookmark)
                viewModel.allTopHeadlines
            }
        }

        holder.cardView.cardViewTopHeadlines.setOnClickListener() {
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return topHeadlinesList.size

    }


    private fun handleResponse(list : List<Articles>) {

    }
    private fun handleResponseAdd() {
        Toast.makeText(view.context, "added to bookmarks", Toast.LENGTH_SHORT).show();
    }

    private fun handleResponseDelete() {
        Toast.makeText(view.context, "removed from bookmarks", Toast.LENGTH_SHORT).show();
    }

}