package com.rodrigo.poketor.app.cards

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigo.poketor.Screen
import com.rodrigo.poketor.core.fixtures.dto.CardDto
import com.rodrigo.poketor.usecases.GetCardsBySetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor (
    private val getCardsBySetUseCase: GetCardsBySetUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){
    var cardsState by mutableStateOf<CardsState>(CardsState.Idle)
        private set

    private val filter = savedStateHandle[Screen.Cards.ARG_FILTER]?:""

    init {
        getCards(filter)
    }

    private fun getCards(filter:String){
        viewModelScope.launch {
            cardsState = CardsState.Loading
            getCardsBySetUseCase(filter)
                .onSuccess { cardsState = CardsState.Success(it) }
                .onFailure { cardsState = CardsState.Error(it.message?:"Error") }

        }
    }
}

sealed class CardsState{
    object Idle: CardsState()
    object Loading: CardsState()
    data class Success(val cards: List<CardDto>): CardsState()
    data class Error(val message: String): CardsState()
}