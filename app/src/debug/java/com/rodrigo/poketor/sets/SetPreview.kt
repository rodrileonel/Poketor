package com.rodrigo.poketor.sets

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigo.poketor.app.sets.SetItem
import com.rodrigo.poketor.core.fixtures.SetFixtures
import com.rodrigo.poketor.ui.theme.PoketorTheme

@Preview(showBackground = true)
@Composable
fun SetPreview() {
    PoketorTheme {
        SetItem(SetFixtures.ascended())
    }
}