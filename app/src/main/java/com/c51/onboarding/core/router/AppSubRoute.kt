package com.c51.onboarding.core.router

import com.c51.onboarding.feature.bonus.BonusDetailActivity
import com.c51.onboarding.feature.offers.ui.OfferListActivity

class AppSubRoute : ISubRoute {
    override fun registerSubRoute(map: HashMap<String, RouteMeta>) {
        map[ROUTE_BONUS_PLAN] = RouteMeta(ROUTE_BONUS_PLAN, BonusDetailActivity::class.java)
        map[ROUTE_OFFER_LIST] = RouteMeta(ROUTE_OFFER_LIST, OfferListActivity::class.java)
    }
}

const val ROUTE_BONUS_PLAN = "bonusPlan"
const val ROUTE_OFFER_LIST = "offerList"