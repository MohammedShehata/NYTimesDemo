package com.sh.nytimes.ui.fragments.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sh.nytimes.data.models.Article
import com.sh.nytimes.databinding.FragmentArticlesBinding
import com.sh.nytimes.ui.BaseViewModel
import com.sh.nytimes.ui.fragments.BaseFragment

class ArticlesFragment : BaseFragment<FragmentArticlesBinding>() {

    private val articlesViewModel: ArticlesViewModel by viewModels()

    override fun initView() {

        binding.recyclerViewArticles.adapter = ArticlesAdapter(object : OnArticleClickListener {
            override fun onArticleClick(article: Article) {
                goToDetails(article)
            }
        })
        binding.swipeRefreshLayout.setOnRefreshListener {
            articlesViewModel.fetchArticles()
        }
    }

    override fun getBindingView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentArticlesBinding {

        return FragmentArticlesBinding.inflate(inflater, container, false)
    }

    override fun getBaseViewModel(): BaseViewModel = articlesViewModel

    override fun onLoading(loading: Boolean?) {
        binding.swipeRefreshLayout.isRefreshing = loading != null && loading
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articlesViewModel.articles.observe(viewLifecycleOwner, {
            it?.let {
                (binding.recyclerViewArticles.adapter as ArticlesAdapter).setData(it)
            }
        })
    }

    private fun goToDetails(article: Article) {
        val action =
            ArticlesFragmentDirections.actionArticlesFragmentToArticleDetailsFragment(article)
        findNavController().navigate(action)
    }

    interface OnArticleClickListener {
        fun onArticleClick(article: Article)
    }
}