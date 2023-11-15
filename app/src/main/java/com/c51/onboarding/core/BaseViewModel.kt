package com.c51.onboarding.core

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.core.component.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {
    val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}