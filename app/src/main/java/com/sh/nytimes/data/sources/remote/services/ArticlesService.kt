package com.sh.nytimes.data.sources.remote.services

import com.sh.nytimes.BuildConfig
import com.sh.nytimes.data.responses.ArticlesResponse
import com.sh.nytimes.data.sources.remote.ApiManager
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticlesService {

    @GET("viewed/{period}.json?api-key=${BuildConfig.API_KEY}")
    fun getViewed(@Path("period") period: Int): Call<ArticlesResponse>


    companion object {
        const val ONE_DAY = 1
        const val SEVEN_DAYS = 7
        const val THIRTY_DAYS = 30

        fun create(): ArticlesService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiManager.BASE_URL)
                .build()
                .create(ArticlesService::class.java)
        }
    }
}