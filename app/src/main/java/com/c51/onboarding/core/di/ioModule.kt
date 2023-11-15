package com.c51.onboarding.core.di

import com.c51.onboarding.core.io.BatchApi
import com.c51.onboarding.core.io.MyHttpClient
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val ioModule = module {
    single<OkHttpClient> { MyHttpClient.getClient() }
    single<Retrofit> {
        val host = "https://public-api.checkout51.com/"
        Retrofit.Builder()
            .baseUrl(host)
            .client(get())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory<BatchApi> {
        val retrofit : Retrofit = get()
        retrofit.create(BatchApi::class.java)
    }
}