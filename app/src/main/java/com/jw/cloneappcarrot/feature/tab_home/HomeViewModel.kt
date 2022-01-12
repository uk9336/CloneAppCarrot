package com.jw.cloneappcarrot.feature.tab_home

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jw.cloneappcarrot.base.BaseFragmentViewModel
import com.jw.cloneappcarrot.common.Dlog
import com.jw.cloneappcarrot.feature.Command
import com.jw.cloneappcarrot.feature.product.ProductActivity
import com.jw.cloneappcarrot.model.JsonProduct
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
class HomeViewModel @Inject constructor() : BaseFragmentViewModel() {

    override fun onHandleEvent(event: Command) {
        Dlog.d("viewId => ${event.view?.id}")
        when (event.id) {
            Command.HOME_ITEM -> {
                Dlog.d("HOME_ITEM")

                // 상품 정보보기 화면으로 이동
                startActivity(
                    ProductActivity::class.java,
                    "info",
                    homeList.value!![event.index],
                    ActivityOptions.makeSceneTransitionAnimation(
                        activity,
                        event.view,
                        "image_transform"
                    ).toBundle()
                )
            }
        }
    }

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
        viewModelScope.launch {
            val data = HomeRepositoryImpl.getHomeList()
            withContext(Main) {
                _homeList.value = data
            }
        }
    }
}