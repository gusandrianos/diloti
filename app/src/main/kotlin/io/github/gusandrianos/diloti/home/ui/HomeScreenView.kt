package io.github.gusandrianos.diloti.home.ui

import io.github.gusandrianos.diloti.game.domain.model.Game
import io.github.gusandrianos.diloti.game.domain.model.Match
import io.github.gusandrianos.diloti.game.domain.model.Player
import java.time.Instant

internal class HomeScreenView {
    data class State(
        val games: List<Match>
    )
}

internal val tempState = HomeScreenView.State(
    listOf(
        Match(
            name = "Match 1",
            players = Player("Player 1") to Player("Player 2"),
            games = listOf(
                Game(
                    score = mapOf(
                        Player("Player 1") to 61,
                        Player("Player 2") to 52
                    ),
                    playedOn = Instant.now()
                ),
                Game(
                    score = mapOf(
                        Player("Player 1") to 42,
                        Player("Player 2") to 52
                    ),
                    playedOn = Instant.now()
                ),
            ),
            maxRounds = 3
        ), Match(
            name = "Match 2",
            players = Player("Player 1") to Player("Player 2"),
            games = listOf(
                Game(
                    score = mapOf(
                        Player("Player 1") to 61,
                        Player("Player 2") to 52
                    ),
                    playedOn = Instant.now()
                ),
                Game(
                    score = mapOf(
                        Player("Player 1") to 42,
                        Player("Player 2") to 125
                    ),
                    playedOn = Instant.now()
                ),
                Game(
                    score = mapOf(
                        Player("Player 1") to 62,
                        Player("Player 2") to 52
                    ),
                    playedOn = Instant.now()
                ),
            ),
            maxRounds = 3
        ),
        Match(
            name = "Match 3",
            players = Player("Player 1") to Player("Player 2"),
            games = listOf(
                Game(
                    score = mapOf(
                        Player("Player 1") to 0,
                        Player("Player 2") to 0
                    ),
                    playedOn = Instant.now()
                )
            ),
            maxRounds = 5
        )
    )
)
