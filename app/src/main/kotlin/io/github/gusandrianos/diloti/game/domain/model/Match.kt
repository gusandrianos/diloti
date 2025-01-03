package io.github.gusandrianos.diloti.game.domain.model

internal data class Match(
    val name: String,
    val players: Pair<Player, Player>,
    val games: List<Game>,
    val maxRounds: Int,
) {
    val score: Map<Player, Int> = games.fold(
        mapOf(players.first to 0, players.second to 0)
    ) { score, game ->
        score.mapValues { (player, score) ->
            score + (game.score[player] ?: 0)
        }
    }
    val winner: Player? = score.maxByOrNull {
        it.value
    }?.takeIf {
        it.value == (maxRounds / 2 + 1)
    }?.key
    val inProgress: Boolean = winner == null
}
