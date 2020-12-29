package com.sh.nytimes.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sh.nytimes.data.models.Article
import com.sh.nytimes.data.responses.ArticlesResponse
import com.sh.nytimes.data.sources.remote.ApiManager
import com.sh.nytimes.data.sources.remote.CallbackWrapper
import com.sh.nytimes.data.sources.remote.services.ArticlesService

class ArticlesRepository : BaseRepository() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    private val articlesService = ApiManager.getArticlesService()

    fun fetchArticles() {
        _loading.postValue(true)
        articlesService.getViewed(ArticlesService.ONE_DAY)
            .enqueue(object : CallbackWrapper<ArticlesResponse>() {
                override fun onSuccess(response: ArticlesResponse) {
                    _articles.postValue(response.results)
                }


                override fun onFailure(errorMessage: Any?) {
                    _message.postValue(errorMessage)
                }

                override fun onComplete() {
                    _loading.postValue(false)
                }
            })
    }
}