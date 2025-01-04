package io.github.gusandrianos.diloti.match.di

import io.github.gusandrianos.diloti.match.ui.MatchViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val matchModule = module {
    viewModelOf(::MatchViewModel)
}
