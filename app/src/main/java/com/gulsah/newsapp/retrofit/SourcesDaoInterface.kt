package com.gulsah.newsapp.retrofit

import com.gulsah.newsapp.model.AllSources
import retrofit2.Call
import retrofit2.http.GET

interface SourcesDaoInterface {
    @GET("top-headlines/sources?apiKey=7091727c995840d9aa553bd8ff84f394")
    fun requestAllSources(): Call<AllSources>
}