package com.rodrigo.poketor.app.sets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SetsScreen(
    setsState: SetsState,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { inner ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(inner)
        ){
            when(setsState){
                is SetsState.Idle -> CircularProgressIndicator()
                is SetsState.Loading -> CircularProgressIndicator()
                is SetsState.Error -> Text("Error")
                is SetsState.Success -> LazyColumn {
                    items(setsState.sets) { set->
                        SetScreen(set)
                    }
                }
            }
        }
    }
}