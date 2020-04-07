package ncit.test.data.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import ncit.test.data.ws.model.UserModel
import ncit.test.data.ws.model.response.UserResponse
import ncit.test.data.ws.rest.ServiceGenerator
import ncit.test.data.ws.rest.listeners.ILoadingListener
import retrofit2.Call
import retrofit2.Callback

class UsersRepository (context: Context, private val loadingListener: ILoadingListener) : BaseRepository(context){
    private val userResponseLiveData: MutableLiveData<UserResponse> = MutableLiveData()
    private val usersLiveData: MutableLiveData<List<UserModel>> = MutableLiveData()

    fun login(username : String, password : String) : MutableLiveData<UserResponse>  {
        val call = ServiceGenerator.clientApi.login(username,password)
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: retrofit2.Response<UserResponse>) {
                if (response.body() !== null) {
                    userResponseLiveData.value = response.body()
                    loadingListener.onComplete()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.printStackTrace()
                loadingListener.onComplete()
            }
        })
        return userResponseLiveData
    }

    fun register(username : String, password : String) : MutableLiveData<UserResponse>  {
        val call = ServiceGenerator.clientApi.register(username,password)
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: retrofit2.Response<UserResponse>) {
                if (response.body() !== null) {
                    userResponseLiveData.value = response.body()
                    loadingListener.onComplete()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.printStackTrace()
                loadingListener.onComplete()
            }
        })
        return userResponseLiveData
    }

    fun getUsers() : MutableLiveData<List<UserModel>>  {
        val call = ServiceGenerator.clientApi.getUsers()
        call.enqueue(object : Callback<List<UserModel>> {
            override fun onResponse(call: Call<List<UserModel>>, response: retrofit2.Response<List<UserModel>>) {
                if (response.body() !== null) {
                    usersLiveData.value = response.body()
                    loadingListener.onComplete()
                }
            }

            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                t.printStackTrace()
                loadingListener.onComplete()
            }
        })
        return usersLiveData
    }
}