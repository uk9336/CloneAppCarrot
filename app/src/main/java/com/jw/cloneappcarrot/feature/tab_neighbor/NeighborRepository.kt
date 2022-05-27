package com.jw.cloneappcarrot.feature.tab_neighbor

import com.jw.cloneappcarrot.model.FakeNeighborList
import com.jw.cloneappcarrot.model.NeighborModel

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