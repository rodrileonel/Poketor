package com.rodrigo.poketor.app.sets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rodrigo.poketor.R
import com.rodrigo.poketor.core.fixtures.dto.SetDto

@Composable
fun SetItem (
    set: SetDto,
    onClick: (String) -> Unit = {}
){
    Card(
        onClick = { onClick(set.id) },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp, horizontal = 4.dp),
            contentAlignment = Alignment.Center,
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                contentDescription = set.name,
                contentScale = ContentScale.Fit,
                placeholder = painterResource(R.drawable.ic_launcher_background),
                error = painterResource(R.drawable.ic_launcher_background),
                model = set.images.logo,
            )
        }
    }
}