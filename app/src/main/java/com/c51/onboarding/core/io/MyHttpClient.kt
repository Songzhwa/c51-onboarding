package com.c51.onboarding.core.io

import com.c51.onboarding.core.MyApp
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit

object MyHttpClient {
    private var okHttpClient: OkHttpClient? = null

    fun getClient(): OkHttpClient {
        if (okHttpClient != null) return okHttpClient!!


        val cacheSize: Long = 15 * 1024 * 1024 // 15MB
        val cacheFolder = MyApp.app().cacheDir
        val targetFolder = File(cacheFolder, "c51-okhttp")
        if (!targetFolder.exists()) {
            targetFolder.mkdir()
        }
        val cache = Cache(targetFolder, cacheSize)

        val builder = OkHttpClient.Builder()
            .connectionPool(ConnectionPool(3, 5, TimeUnit.MINUTES))
            .connectTimeout(30L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .cache(cache)

        // builder.addInterceptor(/*给所有request添加token, language, userId等通用信息*/)
        okHttpClient = builder.build()
        return okHttpClient!!
    }
}