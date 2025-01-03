package io.github.gusandrianos.diloti.game.domain.model

import java.time.Instant

internal data class Game(
    val score: Map<Player, Int>,
    val playedOn: Instant,
) {
    val winner: Player? = score.maxByOrNull { it.value }?.takeIf { it.value >= 61 }?.key
    val inProgress: Boolean = winner == null
}

