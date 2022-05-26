package com.jw.cloneappcarrot.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.cancel
import com.jw.cloneappcarrot.BR

/**
 * Created by LJW on 2021/12/13.
 *
 * Description :
 */
abstract class BaseFragment<B : ViewDataBinding, VM : BaseFragmentViewModel>(
    @LayoutRes val layoutID: Int
) : Fragment() {

    lateinit var binding: B
    lateinit var viewModel: VM
    lateinit var baseActivity: BaseActivity<*, *>
    lateinit var coroutineScope: CoroutineScope

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutID, container, false)
        binding.lifecycleOwner = viewLifecycleOwner // liveData 를 xml binding 하려면 반드시 설정

        baseActivity = activity as BaseActivity<*, *>
        viewModel = defineViewModel().apply {
            activity = baseActivity
            fragment = this@BaseFragment
            lifecycleOwner = viewLifecycleOwner
            activityViewModel = baseActivity.viewModel
        }
        binding.setVariable(BR.viewModel, viewModel)

        coroutineScope = CoroutineScope(Main)

        onCreated(savedInstanceState)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
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

    /***********************************
     * Method
     ***********************************/
    /**
     * ViewModel 반환
     */
    fun <VMC : BaseViewModel> getViewModel(viewModelClass: Class<VMC>): VMC {
//        return ViewModelProvider(this@BaseFragment)[viewModelClass]
        return baseActivity.getViewModel(viewModelClass)
    }
}