package io.github.gusandrianos.diloti.match.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import io.github.gusandrianos.diloti.game.domain.model.Game
import io.github.gusandrianos.diloti.game.domain.model.Player
import io.github.gusandrianos.diloti.ui.theme.DilotiTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MatchScreenRoute(
    matchViewModel: MatchViewModel = koinViewModel(),
    onGamePressed: () -> Unit,
    onBackPressed: () -> Unit
) {
    val state by matchViewModel.state.collectAsStateWithLifecycle()
    DilotiTheme {
        MatchScreen(state, onGamePressed) { onBackPressed() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MatchScreen(
    state: MatchView.State,
    onGamePressed: () -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = state.match.name,
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
            itemsIndexed(state.match.games) { index, item ->
                Game(
                    game = item,
                    index = index + 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) { onGamePressed() }
            }
        }
    }
}

@Composable
private fun Game(
    game: Game,
    index: Int,
    modifier: Modifier = Modifier,
    onGamePressed: () -> Unit,
) {
    Column(modifier.clickable { onGamePressed() }) {
        Text(
            text = stringResource(R.string.match_details_game_title_placeholder, index),
            style = MaterialTheme.typography.headlineSmall
        )
        HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(vertical = 4.dp))
        for (entry in game.score) {
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
private fun MatchScreenPreview() {
    DilotiTheme {
        Surface {
            MatchScreen(
                state = tempMatchState,
                onBackPressed = {},
                onGamePressed = {}
            )
        }
    }
}
