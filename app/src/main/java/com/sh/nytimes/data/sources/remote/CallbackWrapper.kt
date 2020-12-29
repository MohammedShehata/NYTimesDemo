package com.sh.nytimes.data.sources.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


abstract class CallbackWrapper<T> : Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {

        onFailure(t.message)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {

        val body: T? = response.body()
        if (response.isSuccessful && body != null) {
            onSuccess(body)
        } else {
            onFailure("error happened")
        }
    }

    abstract fun onSuccess(response: T)

    abstract fun onFailure(errorMessage: String?)
}