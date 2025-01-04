package io.github.gusandrianos.diloti.match.ui

import io.github.gusandrianos.diloti.game.domain.model.Game
import io.github.gusandrianos.diloti.game.domain.model.Match
import io.github.gusandrianos.diloti.game.domain.model.Player
import io.github.gusandrianos.diloti.game.domain.model.Round
import java.time.Instant

internal class MatchView {
    data class State(
        val match: Match
    )
}

internal val tempMatchState = MatchView.State(
    Match(
        name = "Match 1",
        players = Player("Player 1") to Player("Player 2"),
        games = listOf(
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
            ),
            Game(
                rounds = listOf(
                    Round(
                        mapOf(
                            Player("Player 1") to 20,
                            Player("Player 2") to 10
                        )
                    ),
                ),
                playedOn = Instant.now()
            ),
        ),
        maxRounds = 3
    )
)
