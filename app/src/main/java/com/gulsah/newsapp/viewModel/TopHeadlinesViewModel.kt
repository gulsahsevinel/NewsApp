package com.gulsah.newsapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsah.newsapp.model.Articles
import com.gulsah.newsapp.repo.SourcesRepository
import com.gulsah.newsapp.repo.TopHeadlinesRepository

class TopHeadlinesViewModel : ViewModel() {
    var allTopHeadlines = MutableLiveData<List<Articles>>()
    var id = MutableLiveData<String>()
    val tdaor = TopHeadlinesRepository()

    init {
        allTopHeadlines = tdaor.getTopHeadlines()
    }

    fun allTopHeadlines(id : String) {
        tdaor.loadTopHeadlines(id)
    }

}