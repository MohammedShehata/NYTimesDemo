package com.sh.nytimes.ui.fragments.articles.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.sh.nytimes.databinding.FragmentArticleDetailsBinding
import com.sh.nytimes.ui.BaseViewModel
import com.sh.nytimes.ui.fragments.BaseFragment

class ArticleDetailsFragment : BaseFragment<FragmentArticleDetailsBinding>() {

    private val args: ArticleDetailsFragmentArgs by navArgs()

    override fun initView() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.article = args.article
        binding.executePendingBindings()
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