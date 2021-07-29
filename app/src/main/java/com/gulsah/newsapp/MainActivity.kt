package com.gulsah.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gulsah.newsapp.model.AllSources
import com.gulsah.newsapp.retrofit.ApiUtils
import com.gulsah.newsapp.retrofit.SourcesDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }



}