package com.zopsmart.mobile.newscompose.data

import com.zopsmart.mobile.newscompose.data.Articles

data class NewsResponse(
    var status: String = "",
    var totalResults: Int = 0,
     var articles: ArrayList<Articles> = arrayListOf()
)