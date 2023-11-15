package com.c51.onboarding.core.router

interface ISubRoute {
    fun registerSubRoute(map: HashMap<String, RouteMeta>)
}