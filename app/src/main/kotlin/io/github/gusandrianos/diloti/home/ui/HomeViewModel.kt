package io.github.gusandrianos.diloti.home.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class HomeViewModel : ViewModel() {
    private val _state: MutableStateFlow<HomeView.State> = MutableStateFlow(tempState)
    val state = _state.asStateFlow()
}
