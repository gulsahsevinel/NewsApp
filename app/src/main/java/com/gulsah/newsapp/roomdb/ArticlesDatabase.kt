package com.gulsah.newsapp.roomdb

import android.annotation.SuppressLint
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationCallback
import com.gulsah.newsapp.model.Articles

@Database(
    entities = [Articles::class],
    version = 3,
    exportSchema = true
)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao
}

