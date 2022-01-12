package com.jw.cloneappcarrot.base

import com.jw.cloneappcarrot.common.Dlog
import com.jw.cloneappcarrot.feature.Command

/**
 * Created by LJW on 2022/01/11.
 *
 * Description :
 */
abstract class BaseFragmentViewModel : BaseViewModel() {

    lateinit var fragment: BaseFragment<*, *>
    lateinit var activityViewModel: BaseViewModel

//    abstract fun onHandleEventFragment(event: EventType)
    override fun onHandleEvent(event: Command) {
        Dlog.d("asd")
//        onHandleEventFragment(event)
    }
}