package com.sh.nytimes.ui.fragments.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sh.nytimes.databinding.FragmentArticlesBinding
import com.sh.nytimes.ui.fragments.BaseFragment

class ArticlesFragment : BaseFragment<FragmentArticlesBinding>() {
    override fun initView() {

    }

    override fun getBindingView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentArticlesBinding {

        return FragmentArticlesBinding.inflate(inflater, container, false)
    }
}