package com.jw.cloneappcarrot.feature.tab_neighbor.neighbor_type

import android.os.Bundle
import com.google.gson.Gson
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseActivity
import com.jw.cloneappcarrot.databinding.ActivityNeighborTypeBinding
import com.jw.cloneappcarrot.model.NeighborModel
import com.jw.cloneappcarrot.model.fake.FakeNeighborList
import com.orhanobut.logger.Logger

class NeighborTypeActivity : BaseActivity<ActivityNeighborTypeBinding, NeighborTypeViewModel>(
    R.layout.activity_neighbor_type
) {


    override fun defineViewModel() = NeighborTypeViewModel()

    override fun onCreated(savedInstanceState: Bundle?) {
        val type = intent.getStringExtra("type")
        var list: List<NeighborModel> = listOf()
        list = FakeNeighborList.filter {
            it.type == type
        }
        Logger.d(Gson().toJson(list))
    }
}