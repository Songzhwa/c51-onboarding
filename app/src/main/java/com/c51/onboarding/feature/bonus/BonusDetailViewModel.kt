package com.c51.onboarding.feature.bonus

import com.c51.onboarding.core.BaseViewModel
import com.c51.onboarding.core.io.BatchApi
import com.c51.onboarding.ext.schedules

class BonusDetailViewModel(val api: BatchApi) : BaseViewModel() {
    fun fetchBonus(bonusId: Int) =
        api.getBonusPlan(bonusId)
            .schedules()

}