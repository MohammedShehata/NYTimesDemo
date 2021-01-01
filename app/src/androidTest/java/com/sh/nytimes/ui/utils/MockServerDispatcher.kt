package com.sh.nytimes.ui.utils

import android.util.Log
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockServerDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        Log.d("com.test", "path > ${request.path}")
        return if (request.path!!.startsWith("/viewed")) {
            MockResponse().setResponseCode(OK).setBody(MockDataUtil.getResponseFile())
        } else {
            MockResponse().setResponseCode(NOT_FOUND)
        }
    }

    companion object {
        private const val OK = 200
        private const val NOT_FOUND = 404
    }
}