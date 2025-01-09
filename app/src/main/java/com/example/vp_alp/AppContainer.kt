package com.example.vp_alp

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.vp_alp.Repository.AuthenticationRepository
import com.example.vp_alp.Repository.NetworkAuthenticationRepository
import com.example.vp_alp.Repository.NetworkUserRepository
import com.example.vp_alp.Repository.UserRepository
import com.example.vp_alp.Service.AuthenticationAPIService
import com.example.vp_alp.Service.UserAPIService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface AppContainer {
    val authenticationRepository: AuthenticationRepository
    val userRepository: UserRepository
}

class DefaultAppContainer (
    private val userDataStore: DataStore<Preferences>
): AppContainer {
    // change it to local ip please
    private val baseUrl = "http://10.0.2.2:3000/"

    // delay object creation until needed using lazy
    private val authenticationRetrofitService: AuthenticationAPIService by lazy {
        val retrofit = initRetrofit()

        retrofit.create(AuthenticationAPIService::class.java)
    }

    private val userRetrofitService: UserAPIService by lazy {
        val retrofit = initRetrofit()

        retrofit.create(UserAPIService::class.java)
    }

    // Passing in the required objects is called dependency injection (DI). It is also known as inversion of control.
    override val authenticationRepository: AuthenticationRepository by lazy {
        NetworkAuthenticationRepository(authenticationRetrofitService)
    }

    override val userRepository: UserRepository by lazy {
        NetworkUserRepository(userDataStore, userRetrofitService)
    }

    private fun initRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)

        return Retrofit
            .Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .client(client.build())
            .baseUrl(baseUrl)
            .build()
    }
}