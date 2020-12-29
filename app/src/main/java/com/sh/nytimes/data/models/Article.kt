package com.sh.nytimes.data.models

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("abstract") val abstractDescription: String,
    @SerializedName("adx_keywords")
    val adxKeywords: String,
    val byline: String,
    val id: Long,
    val media: List<Media>,
    @SerializedName("published_date")
    val publishedDate: String,
    val section: String,
    val source: String,
    val subsection: String,
    val title: String,
    val type: String,
    val updated: String,
    val uri: String,
    val url: String
)