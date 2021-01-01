package com.sh.nytimes.ui.utils

import androidx.test.InstrumentationRegistry
import com.google.gson.Gson
import com.sh.nytimes.data.models.Article
import com.sh.nytimes.data.responses.ArticlesResponse
import okio.Buffer

object MockDataUtil {

    fun getResponseFile(): Buffer {
        val inputStream =
            getContext().assets.open("mocked_articles.json")
        return Buffer().readFrom(inputStream)
    }

    fun getArticle(position: Int): Article {
        val inputStream =
            getContext().assets.open("mocked_articles.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        return Gson().fromJson(String(buffer), ArticlesResponse::class.java).results[position]
    }

    private fun getContext() = InstrumentationRegistry.getTargetContext().applicationContext
}