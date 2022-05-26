package com.jw.cloneappcarrot.base


/**
 * Created by LJW on 2022/01/11.
 *
 * Description :
 */
abstract class BaseFragmentViewModel : BaseViewModel() {

    lateinit var fragment: BaseFragment<*, *>
    lateinit var activityViewModel: BaseViewModel
}