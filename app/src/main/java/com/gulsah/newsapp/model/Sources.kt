package com.gulsah.newsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Sources(
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("url")
    @Expose
    var url: String,
    @SerializedName("category")
    @Expose
    var category: String,
    @SerializedName("language")
    @Expose
    var language: String,
    @SerializedName("country")
    @Expose
    var country: String
) : Serializable {
}