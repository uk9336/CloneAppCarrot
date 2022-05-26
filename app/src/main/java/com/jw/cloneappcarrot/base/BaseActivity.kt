package com.jw.cloneappcarrot.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.jw.cloneappcarrot.BR
import com.jw.cloneappcarrot.extension.repeatOnStarted
import kotlinx.coroutines.flow.collect

/**
 * Created by LJW on 2021/12/12.
 *
 * Description :
 */
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes val layoutId: Int
) : AppCompatActivity() {

    lateinit var binding: B
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this // liveData 를 xml binding 하려면 반드시 설정
        viewModel = defineViewModel().apply {
            activity = this@BaseActivity
            lifecycleOwner = this@BaseActivity
        }
        binding.setVariable(BR.viewModel, viewModel)

        onCreated(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        onDestroyed()
    }

    /***********************************
     * abstract
     ***********************************/
    /**
     * ViewModel 생성
     *
     * @return
     */
    protected abstract fun defineViewModel(): VM

    /**
     * onCreate() 를 하위 객체로 연계, activity 의 시작을 이 메서드로 한다.
     */
    protected abstract fun onCreated(savedInstanceState: Bundle?)
    protected open fun onDestroyed() {}


    /***********************************
     * Method
     ***********************************/
    /**
     * ViewModel 반환
     */
    fun <VMC : BaseViewModel> getViewModel(viewModelsClass: Class<VMC>): VMC {
        return ViewModelProvider(this@BaseActivity)[viewModelsClass]
    }
}