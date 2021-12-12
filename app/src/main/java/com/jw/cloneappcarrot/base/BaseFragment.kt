package com.jw.cloneappcarrot.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.cancel
import com.jw.cloneappcarrot.BR

/**
 * Created by LJW on 2021/12/13.
 *
 * Description :
 */
abstract class BaseFragment<B : ViewDataBinding, R : ViewModel>(
    @LayoutRes val layoutID: Int
) : Fragment() {

    lateinit var binding: B
    abstract val viewModel: R
    lateinit var coroutineScope: CoroutineScope

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutID, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = requireActivity()
        coroutineScope = CoroutineScope(Main)
        init()
        return binding.root
    }

    abstract fun init()

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }
}