package com.gulsah.newsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopHeadlines(
    @SerializedName("status")
    @Expose
    var status: String,
    @SerializedName("totalResults")
    @Expose
    var totalResults: String,
    @SerializedName("articles")
    @Expose
    var articles: List<Articles>,

    ) {
}