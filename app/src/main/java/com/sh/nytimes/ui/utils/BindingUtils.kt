package com.sh.nytimes.ui.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.sh.nytimes.R
import com.sh.nytimes.data.models.Article

@BindingAdapter("article")
fun loadArticleImage(imageView: ImageView, article: Article) {
    var imgUrl: String? = null
    if (article.media.isNotEmpty()) {
        imgUrl = article.media[0].metadata[2].url
    }
    if (imgUrl == null) {
        imageView.visibility = View.GONE
    } else {
        imageView.visibility = View.VISIBLE
        Glide.with(imageView)
            .load(imgUrl)
            .apply(
                RequestOptions().transform(
                    CenterCrop(),
                    RoundedCorners(
                        imageView.context.resources.getDimension(R.dimen.image_radius).toInt()
                    )
                )
            ).apply(RequestOptions.placeholderOf(R.drawable.ic_launcher_background))
            .into(imageView)
    }
}

@BindingAdapter("captionArticle")
fun setArticleImageCaption(textView: TextView, article: Article) {
    var captionText: String? = null
    if (article.media.isNotEmpty()) {
        captionText = article.media[0].caption
    }
    if (captionText.isNullOrEmpty()) {
        textView.visibility = View.GONE
    } else {
        textView.visibility = View.VISIBLE
        textView.text = captionText
    }
}