package com.jw.cloneappcarrot.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jw.cloneappcarrot.base.BaseViewModel
import com.jw.cloneappcarrot.common.Dlog
import com.jw.cloneappcarrot.feature.Command
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

    override fun onHandleEvent(event: Command) {
        Dlog.d("event.id => ${event.id}")
        when (event.id) {
            Command.MAIN_FAB_1 -> {
                if (fabOpen.value == null)
                    _fabOpen.value = true
                else _fabOpen.value = !fabOpen.value!!
            }
            Command.MAIN_DIMENSION -> {
                _fabOpen.value = false
            }
        }
    }

    override fun onInitInternal() {

    }


}