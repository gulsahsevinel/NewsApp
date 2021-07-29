package com.gulsah.newsapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsah.newsapp.model.Sources
import com.gulsah.newsapp.repo.SourcesRepository

class SourcesViewModel : ViewModel() {
    var allSourcesList = MutableLiveData<List<Sources>>()
    val sdaor = SourcesRepository()

    init {
        sourcesLoad()
        allSourcesList = sdaor.getAllSources()

    }

    private fun sourcesLoad(){
        sdaor.loadAllSources()
    }

}