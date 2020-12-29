package com.sh.nytimes.ui.fragments.articles.details

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sh.nytimes.databinding.FragmentArticleDetailsBinding
import com.sh.nytimes.ui.BaseViewModel
import com.sh.nytimes.ui.fragments.BaseFragment

class ArticleDetails : BaseFragment<FragmentArticleDetailsBinding>() {
    override fun initView() {

    }

    override fun getBaseViewModel(): BaseViewModel? = null

    override fun getBindingView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentArticleDetailsBinding {
        return FragmentArticleDetailsBinding.inflate(inflater, container, false)
    }

    override fun onLoading(loading: Boolean?) {
    }
}