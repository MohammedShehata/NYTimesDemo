package com.sh.nytimes.data.models

import android.os.Parcel
import android.os.Parcelable
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readLong(),
        parcel.createTypedArrayList(Media)!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(abstractDescription)
        parcel.writeString(adxKeywords)
        parcel.writeString(byline)
        parcel.writeLong(id)
        parcel.writeTypedList(media)
        parcel.writeString(publishedDate)
        parcel.writeString(section)
        parcel.writeString(source)
        parcel.writeString(subsection)
        parcel.writeString(title)
        parcel.writeString(type)
        parcel.writeString(updated)
        parcel.writeString(uri)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }
}