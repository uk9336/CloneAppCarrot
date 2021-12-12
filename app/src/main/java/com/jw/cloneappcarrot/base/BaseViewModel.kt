package com.jw.cloneappcarrot.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

/**
 * Created by LJW on 2021/12/13.
 *
 * Description :
 */
abstract class BaseViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}