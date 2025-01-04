package io.github.gusandrianos.diloti.game_details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.gusandrianos.diloti.R
import io.github.gusandrianos.diloti.game.domain.model.Player
import io.github.gusandrianos.diloti.game.domain.model.Round
import io.github.gusandrianos.diloti.ui.theme.DilotiTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun GameDetailsScreenRoute(
    gameDetailsViewModel: GameDetailsViewModel = koinViewModel(),
    onBackPressed: () -> Unit
) {
    val state by gameDetailsViewModel.state.collectAsStateWithLifecycle()
    DilotiTheme {
        GameDetailsScreen(state) { onBackPressed() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GameDetailsScreen(
    state: GameDetailsView.State,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.game_details_screen_title),
                        style = MaterialTheme.typography.headlineLarge,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Image(
                            painter = painterResource(R.drawable.ic_back),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                    }
                }
            )
        }
    ) { contentPadding ->
        LazyColumn(modifier = Modifier.padding(contentPadding)) {
            itemsIndexed(state.game.rounds) { index, item ->
                Round(
                    round = item,
                    index = index + 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun Round(
    round: Round,
    index: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            text = stringResource(R.string.game_details_round_title_placeholder, index),
            style = MaterialTheme.typography.headlineSmall
        )
        HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(vertical = 4.dp))
        for (entry in round.score) {
            PlayerRow(player = entry.key, score = entry.value, modifier = Modifier.padding(2.dp))
        }
    }
}

@Composable
private fun PlayerRow(
    player: Player,
    score: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(text = player.name)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = score.toString(),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}


@Preview
@Composable
private fun GameDetailsScreenPreview() {
    DilotiTheme {
        Surface {
            GameDetailsScreen(tempGameDetails) {}
        }
    }
}
