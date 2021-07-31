package com.gulsah.newsapp.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Articles(

    @ColumnInfo(name = "author")
    @SerializedName("author")
    @Expose
    var author: String,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    var title: String,
    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    var url: String,
    @ColumnInfo(name = "urlToImage")
    @SerializedName("urlToImage")
    @Expose
    var urlToImage: String,
    @ColumnInfo(name = "bookmarkStatus")
    var bookmarkStatus: Int


) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}