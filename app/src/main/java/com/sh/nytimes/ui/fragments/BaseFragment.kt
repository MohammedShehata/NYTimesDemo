package com.sh.nytimes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    protected lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = getBindingView(inflater, container)
        initView()
        return binding.root
    }

    abstract fun initView()

    abstract fun getBindingView(inflater: LayoutInflater, container: ViewGroup?): B
}