package com.sh.nytimes.ui.fragments.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sh.nytimes.data.models.Article
import com.sh.nytimes.databinding.CellArticlesBinding

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    private val articles = ArrayList<Article>()

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.binding.article = articles[position]
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            CellArticlesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = articles.size

    fun setData(articles: List<Article>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }

    class ArticleViewHolder(val binding: CellArticlesBinding) :
        RecyclerView.ViewHolder(binding.root)
}