package io.github.gusandrianos.diloti.home.di

import io.github.gusandrianos.diloti.home.ui.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::HomeViewModel)
}
