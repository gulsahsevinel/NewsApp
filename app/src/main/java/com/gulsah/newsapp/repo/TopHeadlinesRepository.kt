package com.gulsah.newsapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gulsah.newsapp.model.Articles
import com.gulsah.newsapp.model.TopHeadlines
import com.gulsah.newsapp.retrofit.ApiUtils
import com.gulsah.newsapp.retrofit.SourcesDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopHeadlinesRepository {
    private val topHeadlinesList: MutableLiveData<List<Articles>>
    private val sdaoi: SourcesDaoInterface

    init {
        topHeadlinesList = MutableLiveData()
        sdaoi = ApiUtils.getAllSourcesDaoInterface()
    }

    fun getTopHeadlines(): MutableLiveData<List<Articles>> {
        return topHeadlinesList
    }

    fun loadTopHeadlines(id: String) {
        sdaoi.requestTopHeadlines(id).enqueue(object : Callback<TopHeadlines> {
            override fun onResponse(call: Call<TopHeadlines>, response: Response<TopHeadlines>) {
                val list = response.body()!!.articles
                topHeadlinesList.value = list
            }

            override fun onFailure(call: Call<TopHeadlines>, t: Throwable) {
                Log.e("fail", "fail")
            }
        })
    }

    fun searchTopHeadlines(q: String) {
        sdaoi.searchTopHeadlines(q).enqueue(object : Callback<TopHeadlines> {
            override fun onResponse(call: Call<TopHeadlines>, response: Response<TopHeadlines>) {
                val list = response.body()!!.articles
                topHeadlinesList.value = list
            }

            override fun onFailure(call: Call<TopHeadlines>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}