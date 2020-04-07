package ncit.test.data.ws.rest.listeners

import ncit.test.data.ws.model.response.UserResponse


interface ApiResponseListener {
    fun onSuccess(operation: String, result: UserResponse)
    fun onFailure(operation: String, errorMessage: String)
}
