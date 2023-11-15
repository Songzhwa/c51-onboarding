package com.c51.onboarding.core.router

import android.app.Activity

data class RouteMeta(var targetId: String, val clazz: Class<out Activity>)