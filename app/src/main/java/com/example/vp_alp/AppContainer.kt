package com.example.vp_alp

import androidx.datastore.core.DataStore
import com.example.todolistapp.services.StudyService
import com.example.vp_alp.Repository.NetworkStudyRepository
import com.example.vp_alp.Repository.StudyRepository
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.datastore.preferences.core.Preferences

interface AppContainer {
    val studyRepository: StudyRepository
}

class DefaultAppContainer(
    private val userDataStore: DataStore<Preferences>
) : AppContainer {
    private val APIBaseUrl = "http://192.168.181.156:3000/"

    // RETROFIT SERVICE
    private val studyRetrofitService: StudyService by lazy {
        val retrofit = initRetrofit()
        retrofit.create(StudyService::class.java)
    }

    // REPOSITORY INIT
    override val studyRepository: StudyRepository by lazy {
        NetworkStudyRepository(studyRetrofitService)
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
            .baseUrl(APIBaseUrl)
            .build()
    }
}