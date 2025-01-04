package io.github.gusandrianos.diloti.game.domain.model

import java.time.Instant

internal data class Game(
    val rounds: List<Round>,
    val playedOn: Instant,
) {
    val score: Map<Player, Int>
        get() = rounds.fold(mapOf()) { acc, round ->
            round.score.entries.fold(acc) { innerAcc, (player, score) ->
                innerAcc + (player to (innerAcc[player] ?: 0) + score)
            }
        }
    val winner: Player? = score.maxByOrNull { it.value }?.takeIf { it.value >= 61 }?.key
    val inProgress: Boolean = winner == null
}

