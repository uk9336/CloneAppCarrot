package com.jw.cloneappcarrot.feature.tab_home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jw.cloneappcarrot.model.HomeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {


    /**
     * 홈 탭 데이터 리스트 받아오기
     */
    val _homeList = MutableLiveData<List<HomeModel>>()
    val homeList: LiveData<List<HomeModel>>
        get() = _homeList

    // 내 동네 게시글 리스트 받아오기
    fun getHomeList() {
        viewModelScope.launch {
            val data = HomeRepositoryImpl.getHomeList()
            withContext(Main) {
                _homeList.value = data
            }
        }
    }
}