package com.sh.nytimes.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

open class BaseRepository {

    protected val _message = MutableLiveData<Any?>()
    val message: LiveData<Any?> = _message

    protected val _loading = MutableLiveData<Boolean?>()
    val loading: LiveData<Boolean?> = _loading

    fun resetLoadingAndError() {

        _loading.postValue(null)
        _message.postValue(null)
    }
}