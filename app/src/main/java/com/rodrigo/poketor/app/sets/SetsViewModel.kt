package com.rodrigo.poketor.app.sets

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigo.poketor.data.dto.SetDto
import com.rodrigo.poketor.data.dto.SetsListDto
import com.rodrigo.poketor.usecases.GetSetsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SetsViewModel @Inject constructor(
    private val getSetsUseCase: GetSetsUseCase
): ViewModel() {
    var setsState by mutableStateOf<SetsState>(SetsState.Idle)
        private set

    init {
        getSets()
    }

    private fun getSets() {
        viewModelScope.launch{
            setsState = SetsState.Loading
            getSetsUseCase()
                .onSuccess { setsState = SetsState.Success(it) }
                .onFailure { setsState = SetsState.Error(it.message?:"Error") }
        }
    }
}

sealed class SetsState{
    object Idle: SetsState()
    object Loading: SetsState()
    data class Success(val sets: List<SetDto>): SetsState()
    data class Error(val message: String): SetsState()
}