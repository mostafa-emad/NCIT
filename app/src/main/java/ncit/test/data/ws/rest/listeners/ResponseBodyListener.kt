package ncit.test.data.ws.rest.listeners

import okhttp3.ResponseBody

interface ResponseBodyListener {
    fun onSuccess(operation: String, result: ResponseBody)
    fun onFailure(operation: String, errorMessage: String)
}
