package io.github.gusandrianos.diloti.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.gusandrianos.diloti.R
import io.github.gusandrianos.diloti.game.domain.model.Match
import io.github.gusandrianos.diloti.game.domain.model.Player
import io.github.gusandrianos.diloti.ui.theme.DilotiTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun HomeScreenRoute(
    homeViewModel: HomeViewModel = koinViewModel()
) {
    val state by homeViewModel.state.collectAsStateWithLifecycle()
    HomeScreen(state)
}

@Composable
private fun HomeScreen(
    state: HomeView.State
) {
    Scaffold(
        topBar = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
    ) { contentPadding ->
        LazyColumn(modifier = Modifier.padding(contentPadding)) {
            items(state.games) {
                Match(
                    match = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun Match(
    match: Match,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(text = match.name, style = MaterialTheme.typography.headlineSmall)
        HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(vertical = 4.dp))
        for (entry in match.score) {
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
private fun HomeScreenPreview() {
    DilotiTheme {
        Surface {
            HomeScreen(tempState)
        }
    }
}
