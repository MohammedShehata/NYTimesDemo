package com.sh.nytimes.data.sources.remote


import com.sh.nytimes.BuildConfig
import com.sh.nytimes.data.sources.remote.services.ArticlesService

object ApiManager {

    const val BASE_URL = BuildConfig.BASE_URL

    private lateinit var articlesService: ArticlesService
    fun getArticlesService(): ArticlesService {
        if (!::articlesService.isInitialized) {
            synchronized(this) {
                articlesService = ArticlesService.create()
            }
        }
        return articlesService
    }
}