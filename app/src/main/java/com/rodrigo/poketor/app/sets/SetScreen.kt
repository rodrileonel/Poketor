package com.rodrigo.poketor.app.sets

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rodrigo.poketor.core.fixtures.dto.SetDto

@Composable
fun SetScreen (
    set: SetDto
){
    Text(
        modifier = Modifier.clickable(enabled = true){},
        text = set.name
    )
}