package io.github.gusandrianos.diloti.game_details.di

import io.github.gusandrianos.diloti.game_details.ui.GameDetailsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val gameDetailsModule = module {
    viewModelOf(::GameDetailsViewModel)
}
