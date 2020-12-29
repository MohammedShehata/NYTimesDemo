package com.sh.nytimes.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sh.nytimes.data.repositories.BaseRepository

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    fun resetLoadingAndError() {

        getBaseRepository().resetLoadingAndError()
    }

    fun getLoading(): LiveData<Boolean?> {
        return getBaseRepository().loading
    }

    fun getError(): LiveData<Any?> {
        return getBaseRepository().message
    }

    protected abstract fun getBaseRepository(): BaseRepository
}