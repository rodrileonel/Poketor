package com.rodrigo.poketor.app.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.rodrigo.poketor.R
import com.rodrigo.poketor.app.cards.dialogs.CardDetailDialog
import com.rodrigo.poketor.core.fixtures.dto.CardDto
import com.rodrigo.poketor.utils.PokemonTestTags
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@Composable
fun CardItem (
    card: CardDto
){
    var showDialogAnimation by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(PokemonTestTags.CARD_ITEM),
        onClick = {
            //showFullScreen = true
            showDialog = true
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                contentDescription = card.name,
                contentScale = ContentScale.Fit,
                placeholder = painterResource(R.drawable.ic_launcher_background),
                error = painterResource(R.drawable.ic_launcher_background),
                model = card.images.large,
            )
        }
    }

    if (showDialog) {
        Dialog(
            onDismissRequest = { },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            LaunchedEffect(Unit) {
                showDialogAnimation = false
                // delay(16) // ~1 frame (60fps)
                yield()
                showDialogAnimation = true
            }

            CardDetailDialog(
                imageUrl = card.images.large,
                isVisible = showDialogAnimation,
                dialogTime = 500,
                onDismiss = { showDialogAnimation = false }
            )

            LaunchedEffect(showDialogAnimation) {
                if (!showDialogAnimation) {
                    delay(500)
                    showDialog = false
                }
            }
        }
    }
}