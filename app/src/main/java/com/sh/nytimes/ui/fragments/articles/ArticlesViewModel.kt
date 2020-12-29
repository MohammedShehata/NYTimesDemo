package com.sh.nytimes.ui.fragments.articles

import android.app.Application
import com.sh.nytimes.data.repositories.ArticlesRepository
import com.sh.nytimes.data.repositories.BaseRepository
import com.sh.nytimes.ui.BaseViewModel

class ArticlesViewModel(application: Application) : BaseViewModel(application) {

    private val articlesRepository = ArticlesRepository()
    val articles = articlesRepository.articles

    init {
        fetchArticles()
    }

    fun fetchArticles() {
        articlesRepository.fetchArticles()
    }

    override fun getBaseRepository(): BaseRepository = articlesRepository
}