package com.gulsah.newsapp.retrofit

import com.gulsah.newsapp.model.AllSources
import com.gulsah.newsapp.model.TopHeadlines
import com.gulsah.newsapp.retrofit.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SourcesDaoInterface {
    @GET("top-headlines/sources?apiKey=7091727c995840d9aa553bd8ff84f394")
    fun requestAllSources(): Call<AllSources>

    @GET("top-headlines")
    fun requestTopHeadlines(
        @Query("sources")
        sources: String,
        @Query("apiKey")
        apiKey : String = API_KEY
    ): Call<TopHeadlines>
}