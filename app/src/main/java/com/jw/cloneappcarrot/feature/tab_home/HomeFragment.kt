package com.jw.cloneappcarrot.feature.tab_home

import android.os.Bundle
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseFragment
import com.jw.cloneappcarrot.databinding.FragmentHomeBinding
import com.jw.cloneappcarrot.model.JsonProduct
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override fun defineViewModel() = getViewModel(HomeViewModel::class.java)

    override fun onCreated(savedInstanceState: Bundle?) {}
}

@BindingAdapter("homeData", "viewModel")
fun bindHomeData(recyclerView: RecyclerView, list: List<JsonProduct>?, viewModel: HomeViewModel) {
    list?.let {
        recyclerView.run {
            adapter as HomeAdapter? ?: run {
                HomeAdapter(viewModel).also {
                    adapter = it
                }
            }
        }.items = list
    }
}