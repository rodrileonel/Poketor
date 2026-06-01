package com.rodrigo.poketor.app.sets

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.rodrigo.poketor.core.fixtures.SetFixtures
import com.rodrigo.poketor.utils.PokemonTestTags
import org.junit.Rule
import org.junit.Test

class SetsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val ascendedSet = SetFixtures.ascended()

    @Test
    fun whenStateIsSuccess_setsAreDisplayed(){
        composeTestRule.setContent {
            SetsScreen(
                setsState = SetsState.Success(listOf(ascendedSet)),
                onNavigateToCards = { }
            )
        }

        composeTestRule
            .onNodeWithTag(PokemonTestTags.SET_ITEM)
            .assertIsDisplayed()

    }

    @Test
    fun whenStateIsError_errorMessageIsDisplayed(){
        composeTestRule.setContent {
            SetsScreen(
                setsState = SetsState.Error("Error"),
                onNavigateToCards = { }
            )
        }

        composeTestRule
            .onNodeWithTag(PokemonTestTags.SET_ERROR)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Error")
            .assertIsDisplayed()

    }

    @Test
    fun whenStateIsIdle_loadingIsDisplayed(){
        composeTestRule.setContent {
            SetsScreen(
                setsState = SetsState.Idle,
                onNavigateToCards = { }
            )
        }

        composeTestRule
            .onNodeWithTag(PokemonTestTags.SET_IDLE)
            .assertIsDisplayed()

    }

    @Test
    fun whenStateIsLoading_loadingIsDisplayed(){
        composeTestRule.setContent {
            SetsScreen(
                setsState = SetsState.Loading,
                onNavigateToCards = { }
            )
        }

        composeTestRule
            .onNodeWithTag(PokemonTestTags.SET_LOADING)
            .assertIsDisplayed()

    }
}