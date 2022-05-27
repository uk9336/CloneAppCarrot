package com.jw.cloneappcarrot.feature.tab_neighbor

import android.os.Bundle
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseFragment
import com.jw.cloneappcarrot.databinding.FragmentNeighborBinding
import com.jw.cloneappcarrot.feature.tab_neighbor.adapter.NeighborAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NeighborFragment :
    BaseFragment<FragmentNeighborBinding, NeighborViewModel>(R.layout.fragment_neighbor) {

    override fun defineViewModel() = getViewModel(NeighborViewModel::class.java)

    override fun onCreated(savedInstanceState: Bundle?) {
        viewModel._neighborList.observe(this) {
            val adapter = NeighborAdapter(it, requireActivity())
            binding.recyclerView.adapter = adapter
        }
    }

}