package com.zopsmart.mobile.newscompose.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zopsmart.mobile.newscompose.data.Articles
import com.zopsmart.mobile.newscompose.R
import com.zopsmart.mobile.newscompose.ui.theme.MarvelRed

@Composable
fun NewsList(pair: Pair<List<Articles>, String>) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MarvelRed,
                title = { Text(stringResource(R.string.app_name), color = Color.White) }
            )
        }
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalPagerScreen(pair.first)
                }
            }
            items(pair.first) { article ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable { },
                    elevation = 5.dp
                ) {
                    NewsCard(article)
                }
            }
        }
    }
}





