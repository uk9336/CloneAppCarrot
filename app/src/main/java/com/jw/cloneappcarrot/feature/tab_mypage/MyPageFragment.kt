package com.jw.cloneappcarrot.feature.tab_mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseFragment
import com.jw.cloneappcarrot.databinding.FragmentMypageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMypageBinding, MyPageViewModel>(
    R.layout.fragment_mypage
) {

    override fun defineViewModel() = MyPageViewModel()

    override fun onCreated(savedInstanceState: Bundle?) {
    }

}