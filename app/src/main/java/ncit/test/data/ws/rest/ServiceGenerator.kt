package ncit.test.data.ws.rest

import com.google.gson.GsonBuilder
import ncit.test.data.ws.rest.constants.ApiServicesNames
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator {

    private val client = OkHttpClient.Builder()
        .connectTimeout(ApiServicesNames.CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
        .readTimeout(ApiServicesNames.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        .writeTimeout(ApiServicesNames.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)
        .build()

    val gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(ApiServicesNames.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))

    private val retrofit = retrofitBuilder.build()

    val clientApi: ServicesApi = retrofit.create(ServicesApi::class.java)

}