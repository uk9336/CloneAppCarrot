package com.jw.cloneappcarrot.feature.tab_neighbor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jw.cloneappcarrot.feature.tab_home.HomeRepositoryImpl
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
@HiltViewModel
class NeighborViewModel @Inject constructor() : ViewModel() {

    fun getDate() {
        viewModelScope.launch {
            val data = HomeRepositoryImpl.getHomeList()
            Logger.d(data)
        }
    }
}