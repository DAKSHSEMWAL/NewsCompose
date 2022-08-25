package com.zopsmart.mobile.newscompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.zopsmart.mobile.newscompose.ui.viewmodel.NewsViewModel
import com.zopsmart.mobile.newscompose.ui.composables.NewsList
import com.zopsmart.mobile.newscompose.ui.theme.ComposeDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeDemoTheme {
                val mainViewModel = hiltViewModel<NewsViewModel>()
                // A surface container using the 'background' color from the theme
                NewsList(Pair(mainViewModel.movieListResponse, mainViewModel.errorMessage))
            }
        }
    }

}

