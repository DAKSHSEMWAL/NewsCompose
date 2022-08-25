package com.zopsmart.mobile.newscompose.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zopsmart.mobile.newscompose.network.ApiService
import com.zopsmart.mobile.newscompose.data.Articles
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsApi: ApiService
) : ViewModel() {
    var movieListResponse: List<Articles> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    init {
        getMovieList("us")
    }
    fun getMovieList(countryName: String) {
        viewModelScope.launch {
            try {
                val newsList = newsApi.getNewsData(countryName).articles
                movieListResponse = newsList
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}