package com.c51.onboarding.core.di

import com.c51.onboarding.feature.bonus.BonusDetailViewModel
import com.c51.onboarding.feature.offers.data.OfferListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    viewModel { BonusDetailViewModel(get()) }
    viewModel { OfferListViewModel(get()) }
}