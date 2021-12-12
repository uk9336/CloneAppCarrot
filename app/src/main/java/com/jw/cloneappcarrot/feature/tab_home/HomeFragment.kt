package com.jw.cloneappcarrot.feature.tab_home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
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

    override val viewModel by viewModels<HomeViewModel>()

    private lateinit var adapter: HomeAdapter

    override fun init() {
        // Set Observer
        observeViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 내 동네 게시글 리스트 받아오기
        viewModel.getHomeList()

    }

    // Set Observer
    fun observeViewModel() {

        viewModel.apply {

            // 내 동네 게시글 리스트 구독
            homeList.observe(requireActivity(), Observer {
                // 어뎁터 연결
                adapter = HomeAdapter(it, requireActivity())
                binding.recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), 1))
                binding.recyclerView.adapter = adapter
            })

        }
    }
}