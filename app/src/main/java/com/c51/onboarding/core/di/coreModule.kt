package com.c51.onboarding.core.di

import com.c51.onboarding.core.router.Router
import org.koin.dsl.module

val coreModule = module {
    single { Router() }
}