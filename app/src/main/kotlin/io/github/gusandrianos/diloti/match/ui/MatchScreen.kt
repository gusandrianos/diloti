package io.github.gusandrianos.diloti.match.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.gusandrianos.diloti.R
import io.github.gusandrianos.diloti.ui.ScoreRow
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
                ScoreRow(
                    title = stringResource(
                        R.string.match_details_game_title_placeholder,
                        index + 1
                    ),
                    scores = item.score,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) { onGamePressed() }
            }
        }
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
