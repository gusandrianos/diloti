package io.github.gusandrianos.diloti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.gusandrianos.diloti.game_details.di.gameDetailsModule
import io.github.gusandrianos.diloti.game_details.ui.GameDetailsScreenRoute
import io.github.gusandrianos.diloti.home.di.homeModule
import io.github.gusandrianos.diloti.home.ui.HomeScreenRoute
import io.github.gusandrianos.diloti.match.di.matchModule
import io.github.gusandrianos.diloti.match.ui.MatchScreenRoute
import io.github.gusandrianos.diloti.navigation.GameDetails
import io.github.gusandrianos.diloti.navigation.Home
import io.github.gusandrianos.diloti.navigation.Match
import org.koin.compose.KoinApplication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DilotiApp()
        }
    }
}

@Composable
fun DilotiApp() {
    KoinApplication(
        application = {
            modules(
                homeModule,
                matchModule,
                gameDetailsModule
            )
        }
    ) {
        Screens()
    }
}

@Composable
fun Screens() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreenRoute(
                onNavigateToMatch = {
                    navController.navigate(Match)
                }
            )
        }
        composable<Match> {
            MatchScreenRoute(
                onGamePressed = {
                    navController.navigate(GameDetails)
                },
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
        composable<GameDetails> {
            GameDetailsScreenRoute {
                navController.popBackStack()
            }
        }
    }
}
