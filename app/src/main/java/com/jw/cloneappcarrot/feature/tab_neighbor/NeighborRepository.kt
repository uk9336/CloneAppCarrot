package com.jw.cloneappcarrot.feature.tab_neighbor

import com.jw.cloneappcarrot.model.NeighborModel
import com.jw.cloneappcarrot.model.fake.FakeNeighborList

/**
 * Created by LJW on 2022/05/28.
 *
 * Description :
 */
interface NeighborRepository {
    suspend fun getNeighborList(): List<NeighborModel> {
        return FakeNeighborList
    }
}