package com.c51.onboarding.core

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseActivity : AppCompatActivity {
    // two types of constructor
    constructor() : super()
    constructor(resId: Int) : super(resId)

    protected val disposables: CompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}