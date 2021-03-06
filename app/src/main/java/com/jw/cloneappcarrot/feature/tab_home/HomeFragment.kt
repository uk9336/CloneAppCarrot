package com.jw.cloneappcarrot.feature.tab_home

import android.os.Bundle
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseFragment
import com.jw.cloneappcarrot.databinding.FragmentHomeBinding
import com.jw.cloneappcarrot.feature.tab_home.adapter.HomeAdapter
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

        // Subscribe
        setSubscribe()
    }

    // Subscribe
    private fun setSubscribe() {
        viewModel.behaviorProducts.subscribe {
            val adapter = HomeAdapter(it, baseActivity)
            binding.recyclerView.adapter = adapter
        }
    }
}