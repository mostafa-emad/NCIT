package ncit.test.data.ws.rest

import ncit.test.data.ws.model.UserModel
import ncit.test.data.ws.model.response.UserResponse
import ncit.test.data.ws.rest.constants.ApiServicesNames
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ServicesApi {

    @FormUrlEncoded
    @POST(ApiServicesNames.LOGIN)
    fun login(@Field(ApiServicesNames.QUERY_USER_NAME) username : String,
              @Field(ApiServicesNames.QUERY_PASSWORD) password : String): retrofit2.Call<UserResponse>

    @FormUrlEncoded
    @POST(ApiServicesNames.SIGN_UP)
    fun register(@Field(ApiServicesNames.QUERY_USER_NAME) username : String,
                 @Field(ApiServicesNames.QUERY_PASSWORD) password : String): retrofit2.Call<UserResponse>

    @GET(ApiServicesNames.GET_USERS)
    fun getUsers(): retrofit2.Call<List<UserModel>>

}
