package com.sh.nytimes.data.sources.remote

import com.sh.nytimes.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


abstract class CallbackWrapper<T> : Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {

        onFailure(t.message)
        onComplete()
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {

        val body: T? = response.body()
        if (response.isSuccessful && body != null) {
            onSuccess(body)
        } else {
            onFailure(R.string.error_happened)
        }
        onComplete()
    }

    abstract fun onSuccess(response: T)

    abstract fun onFailure(errorMessage: Any?)

    abstract fun onComplete()
}