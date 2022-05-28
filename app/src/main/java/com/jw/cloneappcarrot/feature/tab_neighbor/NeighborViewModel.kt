package com.jw.cloneappcarrot.feature.tab_neighbor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jw.cloneappcarrot.base.BaseFragmentViewModel
import com.jw.cloneappcarrot.model.NeighborModel
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
class NeighborViewModel @Inject constructor() : BaseFragmentViewModel() {

    val behavior: BehaviorSubject<List<NeighborModel>> = BehaviorSubject.create()

    override fun onInitInternal() {
        getDate()
    }


    /**
     * 동네생활 탭 데이터 리스트 받아오기
     */
    val _neighborList = MutableLiveData<List<NeighborModel>>()
    val neighborList: LiveData<List<NeighborModel>>
        get() = _neighborList


    fun getDate() {
        viewModelScope.launch {
            val data = NeighborRepositoryImpl.getNeighborList()
            _neighborList.value = data
        }
    }

    fun getType() {
    }

}