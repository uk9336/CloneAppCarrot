package com.jw.cloneappcarrot.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jw.cloneappcarrot.base.BaseViewModel
import com.jw.cloneappcarrot.common.Dlog
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    // 플로팅 버튼
    val _fabOpen = MutableLiveData<Boolean>()
    val fabOpen: LiveData<Boolean>
        get() = _fabOpen

    override fun onInitInternal() {}


}