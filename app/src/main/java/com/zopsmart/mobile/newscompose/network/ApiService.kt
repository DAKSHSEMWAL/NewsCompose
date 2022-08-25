package com.zopsmart.mobile.newscompose.network

import com.zopsmart.mobile.newscompose.BuildConfig
import com.zopsmart.mobile.newscompose.data.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("${BuildConfig.BASE_URL}top-headlines")
    suspend fun getNewsData(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = BuildConfig.CONSUMER_KEY
    ): NewsResponse
}
