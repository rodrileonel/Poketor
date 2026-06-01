package com.rodrigo.poketor.app.cards

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.rodrigo.poketor.app.sets.SetsScreen
import com.rodrigo.poketor.app.sets.SetsState
import com.rodrigo.poketor.core.fixtures.CardFixtures
import com.rodrigo.poketor.utils.PokemonTestTags
import org.junit.Rule
import org.junit.Test

class CardsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val cardList = CardFixtures.cardList()

    @Test
    fun whenStateIsSuccess_cardsAreDisplayed(){
        composeTestRule.setContent {
            CardsScreen(
                cardsState = CardsState.Success(cardList.data)
            ) { }
        }

        composeTestRule
            .onNodeWithTag(PokemonTestTags.CARD_ITEM)
            .assertIsDisplayed()
    }

    @Test
    fun whenStateIsERROR_cardsErrorIsDisplayed(){
        composeTestRule.setContent {
            CardsScreen(
                cardsState = CardsState.Error("Error")
            ) { }
        }

        composeTestRule
            .onNodeWithTag(PokemonTestTags.CARD_ERROR)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Error")
            .assertIsDisplayed()
    }

    @Test
    fun whenStateIsIdle_loadingIsDisplayed(){
        composeTestRule.setContent {
            CardsScreen(
                cardsState = CardsState.Idle
            ) { }
        }

        composeTestRule
            .onNodeWithTag(PokemonTestTags.CARD_IDLE)
            .assertIsDisplayed()
    }

    @Test
    fun whenStateIsLoading_loadingIsDisplayed(){
        composeTestRule.setContent {
            CardsScreen(
                cardsState = CardsState.Loading
            ) { }
        }

        composeTestRule
            .onNodeWithTag(PokemonTestTags.CARD_LOADING)
            .assertIsDisplayed()
    }

}