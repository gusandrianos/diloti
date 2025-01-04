package io.github.gusandrianos.diloti.match.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class MatchViewModel : ViewModel() {
    private val _state: MutableStateFlow<MatchView.State> = MutableStateFlow(tempMatchState)
    val state = _state.asStateFlow()
}
