package com.gulsah.newsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllSources(
    @SerializedName("status")
    @Expose
    var status: String,
    @SerializedName("sources")
    @Expose
    var sources: List<Sources>
) {
}