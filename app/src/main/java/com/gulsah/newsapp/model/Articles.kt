package com.gulsah.newsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Articles(
    @SerializedName("source")
    @Expose
    var source : Sources,
    @SerializedName("author")
    @Expose
    var author : String,
    @SerializedName("title")
    @Expose
    var title : String,
    @SerializedName("description")
    @Expose
    var description : String,
    @SerializedName("url")
    @Expose
    var url : String,
    @SerializedName("urlToImage")
    @Expose
    var urlToImage : String,
    @SerializedName("publishedAt")
    @Expose
    var publishedAt : String,
    @SerializedName("content")
    @Expose
    var content : String,

) {
}