package com.jw.cloneappcarrot.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    // 플로팅 버튼
    val _fabOpen = MutableLiveData<Boolean>()
    val fabOpen: LiveData<Boolean>
        get() = _fabOpen

    fun setFabOpen(boolean: Boolean) {
        _fabOpen.value = boolean
    }

}