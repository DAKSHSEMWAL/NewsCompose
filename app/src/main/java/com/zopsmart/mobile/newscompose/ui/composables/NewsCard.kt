package com.zopsmart.mobile.newscompose.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zopsmart.mobile.newscompose.data.Articles
import com.zopsmart.mobile.newscompose.R

@Composable
fun NewsCard(articles: Articles) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        articles.description?.let {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(articles.urlToImage)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(5.dp)
            )
            Text(
                text = it,
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Justify,
            )
        }
    }
}