package com.c51.onboarding.ext

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


fun <T> Observable<T>.schedules(): Observable<T> =
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.schedules(): Flowable<T> =
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

// add a begin action, a end action to hide/show loading animation
fun <T> Observable<T>.aligns(onLoading: ()->Unit, onLoaded: ()->Unit) : Observable<T> =
    this.doOnSubscribe { _ -> onLoading() }
        .doOnComplete(onLoaded)
        .doOnError { err -> onLoaded() }

fun <T> Flowable<T>.aligns(onLoading: ()->Unit, onLoaded: ()->Unit) : Flowable<T> =
    this.doOnSubscribe { _ -> onLoading() }
        .doOnComplete(onLoaded)
        .doOnError { err -> onLoaded() }

fun Disposable.clearedBy(disposableQueue: CompositeDisposable) {
    disposableQueue.add(this)
}