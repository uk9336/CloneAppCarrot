package com.jw.cloneappcarrot.feature.tab_home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jw.cloneappcarrot.base.BaseFragmentViewModel
import com.jw.cloneappcarrot.common.Dlog
import com.jw.cloneappcarrot.model.JsonProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.subjects.BehaviorSubject
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : BaseFragmentViewModel() {

    val behavior: BehaviorSubject<List<JsonProduct>> = BehaviorSubject.create()

    override fun onInitInternal() {
        getHomeData()
    }

    /**
     * 홈 탭 데이터 리스트 받아오기
     */
    val _homeList = MutableLiveData<List<JsonProduct>>()
    val homeList: LiveData<List<JsonProduct>>
        get() = _homeList

    // 내 동네 게시글 리스트 받아오기
    fun getHomeData() {
        Dlog.d("getHomeData")
        viewModelScope.launch {
            val data = HomeRepositoryImpl.getHomeList()
            _homeList.value = data
        }
    }
}