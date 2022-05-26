package com.jw.cloneappcarrot.feature.tab_home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseFragment
import com.jw.cloneappcarrot.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override fun defineViewModel() = getViewModel(HomeViewModel::class.java)

    override fun onCreated(savedInstanceState: Bundle?) {

        viewModel._homeList.observe(this, Observer {
            val adapter = HomeAdapter(it, requireActivity())
            binding.recyclerView.adapter = adapter
        })
    }
}