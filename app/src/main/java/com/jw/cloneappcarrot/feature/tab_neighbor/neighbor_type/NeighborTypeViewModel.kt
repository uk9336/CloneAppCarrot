package com.jw.cloneappcarrot.feature.tab_neighbor.neighbor_type

import androidx.lifecycle.MutableLiveData
import com.jw.cloneappcarrot.base.BaseViewModel
import com.jw.cloneappcarrot.model.NeighborModel
import com.jw.cloneappcarrot.model.fake.FakeNeighborList
import io.reactivex.rxjava3.subjects.BehaviorSubject

/**
 * Created by LJW on 2022/05/28.
 *
 * Description :
 */
class NeighborTypeViewModel : BaseViewModel() {

    val behaviorTypeContent: BehaviorSubject<List<NeighborModel>> = BehaviorSubject.create()
    val typeLiveData = MutableLiveData<String>()

    override fun onInitInternal() {
        getData()
    }

    fun getData() {
        activity = activity as NeighborTypeActivity
        val type = activity.intent.getStringExtra("type")
        typeLiveData.value = type ?: ""
        val list: List<NeighborModel> = FakeNeighborList.filter {
            it.type == type
        }
        behaviorTypeContent.onNext(list)
    }


    fun finishActivity() {
        activity.finish()
    }
}