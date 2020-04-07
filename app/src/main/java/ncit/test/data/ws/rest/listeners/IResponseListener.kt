package ncit.test.data.ws.rest.listeners

import ncit.test.data.ws.model.response.UserResponse

interface IResponseListener {
    fun onSuccess(
        serviceName:String,
        result: UserResponse?
    )
    fun onFailure(serviceName:String)
}
