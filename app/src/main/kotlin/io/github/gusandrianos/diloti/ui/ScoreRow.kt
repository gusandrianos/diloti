package io.github.gusandrianos.diloti.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.gusandrianos.diloti.game.domain.model.Player

@Composable
internal fun ScoreRow(
    modifier: Modifier = Modifier,
    title: String,
    scores: Map<Player, Int>,
    onClick: () -> Unit
) {
    Column(modifier.clickable { onClick() }) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall
        )
        HorizontalDivider(
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        for (entry in scores) {
            PlayerRow(
                player = entry.key,
                score = entry.value,
                modifier = Modifier.padding(2.dp)
            )
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
