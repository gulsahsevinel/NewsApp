package com.gulsah.newsapp.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "https://newsapi.org/v2/"
        fun getAllSourcesDaoInterface(): SourcesDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(SourcesDaoInterface::class.java)
        }
    }
}