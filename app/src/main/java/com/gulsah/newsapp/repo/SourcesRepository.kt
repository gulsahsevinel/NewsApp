package com.gulsah.newsapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gulsah.newsapp.model.AllSources
import com.gulsah.newsapp.model.Sources
import com.gulsah.newsapp.retrofit.ApiUtils
import com.gulsah.newsapp.retrofit.SourcesDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SourcesRepository {
    private val sourcesList: MutableLiveData<List<Sources>>
    private val sdaoi: SourcesDaoInterface

    init {
        sourcesList = MutableLiveData()
        sdaoi = ApiUtils.getAllSourcesDaoInterface()
    }

    fun getAllSources(): MutableLiveData<List<Sources>> {
        return sourcesList
    }


    fun loadAllSources() {
        sdaoi.requestAllSources().enqueue(object : Callback<AllSources> {
            override fun onResponse(call: Call<AllSources>, response: Response<AllSources>) {
                val list = response.body()!!.sources
                sourcesList.value = list
            }

            override fun onFailure(call: Call<AllSources>, t: Throwable) {
                Log.e("fail", "error")
            }

        })
    }


}