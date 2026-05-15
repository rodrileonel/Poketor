package com.rodrigo.poketor.app.sets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SetsScreen(
    setsState: SetsState,
    onNavigateToCards:(String) -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { inner ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().padding(inner)
        ){
            var searchSetText by rememberSaveable { mutableStateOf("") }
            when(setsState){
                is SetsState.Idle -> CircularProgressIndicator()
                is SetsState.Loading -> CircularProgressIndicator()
                is SetsState.Error -> Text("Error")
                is SetsState.Success -> {
                    val filteredSets = setsState.sets.filter { set ->
                        set.name.contains(searchSetText, ignoreCase = true) ||
                                set.id.contains(searchSetText, ignoreCase = true) ||
                                set.series.contains(searchSetText, ignoreCase = true)
                    }
                    Column (
                        modifier = Modifier.fillMaxSize()
                    ){
                        OutlinedTextField(
                            value = searchSetText,
                            onValueChange = { searchSetText = it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            singleLine = true,
                            shape = MaterialTheme.shapes.large,
                            placeholder = { Text("Search...") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            }
                        )
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            items(filteredSets) { set->
                                SetItem(
                                    set,
                                    onClick = onNavigateToCards,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}