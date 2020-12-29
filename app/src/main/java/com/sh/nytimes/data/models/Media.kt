package com.sh.nytimes.data.models

import com.google.gson.annotations.SerializedName

data class Media(
    val caption: String,
    val copyright: String,
    @SerializedName("media-metadata")
    val metadata: List<MediaMetadata>,
    val subtype: String,
    val type: String
)