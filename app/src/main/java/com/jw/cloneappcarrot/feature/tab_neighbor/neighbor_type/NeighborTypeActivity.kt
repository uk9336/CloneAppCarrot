package com.jw.cloneappcarrot.feature.tab_neighbor.neighbor_type

import android.os.Bundle
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseActivity
import com.jw.cloneappcarrot.databinding.ActivityNeighborTypeBinding
import com.jw.cloneappcarrot.feature.tab_neighbor.adapter.NeighborTypeContentAdapter

class NeighborTypeActivity : BaseActivity<ActivityNeighborTypeBinding, NeighborTypeViewModel>(
    R.layout.activity_neighbor_type
) {


    override fun defineViewModel() = NeighborTypeViewModel()

    override fun onCreated(savedInstanceState: Bundle?) {

        // Subscribe
        setSubscribe()
    }

    // Subscribe
    private fun setSubscribe(){
        viewModel.behaviorTypeContent.subscribe {
            val adapter = NeighborTypeContentAdapter(it)
            binding.recyclerView.adapter = adapter
        }
    }
}