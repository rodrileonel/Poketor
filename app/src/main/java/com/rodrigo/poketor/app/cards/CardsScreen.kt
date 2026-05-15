package com.rodrigo.poketor.app.cards

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

@Composable
fun CardsScreen(
    cardsState: CardsState,
    onBack:() -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { inner ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner),
            contentAlignment = Alignment.Center,
        ) {
            var searchCardText by rememberSaveable { mutableStateOf("") }
            when (cardsState) {
                is CardsState.Idle -> CircularProgressIndicator()
                is CardsState.Loading -> CircularProgressIndicator()
                is CardsState.Error -> Text("Error")
                is CardsState.Success -> {
                    val filteredCards = cardsState.cards.filter { card ->
                        card.name.contains(searchCardText, ignoreCase = true)
                    }
                    Column (
                        modifier = Modifier.fillMaxSize()
                    ){
                        OutlinedTextField(
                            value = searchCardText,
                            onValueChange = { searchCardText = it},
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
                            items(filteredCards) { card ->
                                CardItem(card)
                            }
                        }
                    }
                }

            }
        }
    }

}