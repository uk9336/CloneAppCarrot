package com.jw.cloneappcarrot.feature.tab_neighbor

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseFragment
import com.jw.cloneappcarrot.databinding.FragmentNeighborBinding
import com.jw.cloneappcarrot.feature.tab_neighbor.adapter.NeighborAdapter
import com.jw.cloneappcarrot.feature.tab_neighbor.adapter.NeighborTypeAdapter
import com.jw.cloneappcarrot.model.fake.FakeNeighborTypeList
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NeighborFragment :
    BaseFragment<FragmentNeighborBinding, NeighborViewModel>(R.layout.fragment_neighbor) {

    override fun defineViewModel() = getViewModel(NeighborViewModel::class.java)

    override fun onCreated(savedInstanceState: Bundle?) {
        init()
        viewModel._neighborList.observe(this) {
            val adapter = NeighborAdapter(it)
            binding.recyclerView.adapter = adapter
        }
    }

    fun init() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.typeRecyclerView.layoutManager = layoutManager
        val adapter = NeighborTypeAdapter(FakeNeighborTypeList)
        binding.typeRecyclerView.adapter = adapter
    }
}