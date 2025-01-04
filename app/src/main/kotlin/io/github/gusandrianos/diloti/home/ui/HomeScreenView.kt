package io.github.gusandrianos.diloti.home.ui

import io.github.gusandrianos.diloti.game.domain.model.Game
import io.github.gusandrianos.diloti.game.domain.model.Match
import io.github.gusandrianos.diloti.game.domain.model.Player
import io.github.gusandrianos.diloti.game.domain.model.Round
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
        ), Match(
            name = "Match 2",
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
                                Player("Player 1") to 41,
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
                        Round(
                            mapOf(
                                Player("Player 1") to 42,
                                Player("Player 2") to 10
                            )
                        ),
                        Round(
                            mapOf(
                                Player("Player 1") to 112,
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
                                Player("Player 1") to 10,
                                Player("Player 2") to 20
                            )
                        ),
                        Round(
                            mapOf(
                                Player("Player 1") to 10,
                                Player("Player 2") to 42
                            )
                        ),
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
                    rounds = listOf(
                        Round(
                            mapOf(
                                Player("Player 1") to 0,
                                Player("Player 2") to 0
                            )
                        ),
                    ),
                    playedOn = Instant.now()
                )
            ),
            maxRounds = 5
        )
    )
)
