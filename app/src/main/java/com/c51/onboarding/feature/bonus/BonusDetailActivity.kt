package com.c51.onboarding.feature.bonus

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.c51.onboarding.R
import com.c51.onboarding.core.BaseActivity
import com.c51.onboarding.core.router.ROUTE_OFFER_LIST
import com.c51.onboarding.core.router.Router
import com.c51.onboarding.ext.clearedBy
import com.c51.onboarding.ui.rv.adapter.RvViewHolder
import com.c51.onboarding.ui.rv.adapter.oneadapter.OneAdapter
import kotlinx.android.synthetic.main.activity_bonus_detail.ivNext
import kotlinx.android.synthetic.main.activity_bonus_detail.rvBonus
import kotlinx.android.synthetic.main.activity_bonus_detail.tvDescription
import kotlinx.android.synthetic.main.activity_bonus_detail.tvTitle
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BonusDetailActivity : BaseActivity() {
    private val vm: BonusDetailViewModel by viewModel()
    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bonus_detail)

        ivNext.setOnClickListener {
            router.open(ROUTE_OFFER_LIST)
        }

        vm.fetchBonus(948)
            .subscribe { bonus -> renderPage(bonus) }
            .clearedBy(disposables)

    }

    private fun renderPage(bonus: BonusPlanV3) {
        tvTitle.text = bonus.name
        tvDescription.text = bonus.description

        rvBonus.layoutManager = LinearLayoutManager(this)
        val adapter = object: OneAdapter<BonusPlanOfferV3>(R.layout.item_bonus, bonus.offers) {
            override fun apply(vh: RvViewHolder, value: BonusPlanOfferV3, position: Int) {
                vh.setText(R.id.tvName, value.name)
                vh.setImage(R.id.ivBonus, value.image)
            }
        }
        rvBonus.adapter = adapter
    }
}