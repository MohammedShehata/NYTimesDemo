package com.sh.nytimes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.sh.nytimes.ui.BaseViewModel

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
    abstract fun getBaseViewModel(): BaseViewModel?
    abstract fun getBindingView(inflater: LayoutInflater, container: ViewGroup?): B

    fun showMessage(message: String?) {
        message?.let { Toast.makeText(activity, message, Toast.LENGTH_SHORT).show() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBaseViewModel()?.getLoading()?.observe(viewLifecycleOwner, { loading ->
            onLoading(loading)
        })

        getBaseViewModel()?.getError()?.observe(viewLifecycleOwner, {
            if (it is Int) {
                showMessage(getString(it))
            } else {
                showMessage(it.toString())
            }
        })
    }

    abstract fun onLoading(loading: Boolean?)

    override fun onDestroyView() {
        super.onDestroyView()
        getBaseViewModel()?.resetLoadingAndError()
    }
}