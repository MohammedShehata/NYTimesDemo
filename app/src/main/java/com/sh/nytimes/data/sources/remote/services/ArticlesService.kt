package com.sh.nytimes.data.sources.remote.services

import com.sh.nytimes.data.sources.remote.ApiManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ArticlesService {

    companion object {
        fun create(): ArticlesService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiManager.BASE_URL)
                .build()
                .create(ArticlesService::class.java)
        }
    }
}