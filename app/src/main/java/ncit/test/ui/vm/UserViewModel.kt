package ncit.test.ui.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import ncit.test.data.repo.UsersRepository
import ncit.test.data.ws.model.response.UserResponse

class UserViewModel : BaseViewModel() {
    private var usersRepository: UsersRepository? = null
//    private val context = getApplication<Application>().applicationContext

    override fun init(context: Context) {
        super.init(context)
        usersRepository = UsersRepository(context,this)
    }

    fun login(username : String, password : String): MutableLiveData<UserResponse> {
        if(!showLoading()){
            return MutableLiveData()
        }
        return usersRepository!!.login(username,password)
    }

    fun signUp(username : String, password : String): MutableLiveData<UserResponse> {
        if(!showLoading()){
            return MutableLiveData()
        }
        return usersRepository!!.register(username,password)
    }
}
