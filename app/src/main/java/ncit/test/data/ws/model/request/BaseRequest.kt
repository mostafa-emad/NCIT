package ncit.test.data.ws.model.request

import java.io.Serializable

class BaseRequest : Serializable {
    var userID: String? = null
    var authKey: String? = null

}