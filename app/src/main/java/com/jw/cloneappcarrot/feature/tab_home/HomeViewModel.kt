package com.jw.cloneappcarrot.feature.tab_home

import androidx.lifecycle.viewModelScope
import com.jw.cloneappcarrot.base.BaseFragmentViewModel
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

    val behaviorProducts: BehaviorSubject<List<JsonProduct>> = BehaviorSubject.create()

    override fun onInitInternal() {
        getHomeData()
    }

    // 내 동네 게시글 리스트 받아오기
    private fun getHomeData() {
        viewModelScope.launch {
            val data = HomeRepositoryImpl.getHomeList()
            behaviorProducts.onNext(data)
        }
    }
}