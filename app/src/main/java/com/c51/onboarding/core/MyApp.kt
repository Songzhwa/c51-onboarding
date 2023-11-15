package com.c51.onboarding.core

import android.app.Application
import com.c51.onboarding.core.di.coreModule
import com.c51.onboarding.core.di.featureModule
import com.c51.onboarding.core.di.ioModule
import com.c51.onboarding.core.router.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    protected val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate() {
        super.onCreate()
        self = this

        startKoin {
            allowOverride(true)
            androidContext(this@MyApp)
            modules(coreModule, ioModule, featureModule)
        }

        val router: Router = get()
        router.init()
    }

    override fun onTerminate() {
        disposables.dispose()
        super.onTerminate()
    }

    companion object {
        private lateinit var self: MyApp

        fun app(): MyApp {
            return self
        }
    }
}