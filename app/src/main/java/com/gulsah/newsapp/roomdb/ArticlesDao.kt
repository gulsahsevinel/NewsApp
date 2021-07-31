package com.gulsah.newsapp.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gulsah.newsapp.model.Articles
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM Articles")
    fun getALl(): Observable<List<Articles>>

    @Insert
    fun insert(articles: Articles): Completable

    @Delete
    fun delete(articles: Articles): Completable
}