package io.github.gusandrianos.diloti.game_details.ui

import io.github.gusandrianos.diloti.game.domain.model.Game
import io.github.gusandrianos.diloti.game.domain.model.Player
import io.github.gusandrianos.diloti.game.domain.model.Round
import java.time.Instant

internal class GameDetailsView {
    data class State(
        val game: Game,
    )
}

internal val tempGameDetails = GameDetailsView.State(
    Game(
        rounds = listOf(
            Round(
                mapOf(
                    Player("Player 1") to 20,
                    Player("Player 2") to 10
                )
            ),
            Round(
                mapOf(
                    Player("Player 1") to 42,
                    Player("Player 2") to 10
                )
            ),
        ),
        playedOn = Instant.now()
    )
)
