package io.github.gusandrianos.diloti.game_details.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class GameDetailsViewModel : ViewModel() {
    private val _state: MutableStateFlow<GameDetailsView.State> = MutableStateFlow(tempGameDetails)
    val state = _state.asStateFlow()
}
