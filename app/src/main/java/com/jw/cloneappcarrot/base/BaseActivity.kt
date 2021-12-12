package com.jw.cloneappcarrot.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.jw.cloneappcarrot.BR

/**
 * Created by LJW on 2021/12/12.
 *
 * Description :
 */
abstract class BaseActivity<B : ViewDataBinding, R : ViewModel>(
    @LayoutRes val layoutId: Int
) : AppCompatActivity() {

    lateinit var binding : B
    abstract val viewModel : R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)

    }
}