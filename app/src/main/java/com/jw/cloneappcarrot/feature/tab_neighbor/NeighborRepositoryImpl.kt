package com.jw.cloneappcarrot.feature.tab_neighbor

import com.jw.cloneappcarrot.model.NeighborModel

/**
 * Created by LJW on 2022/05/28.
 *
 * Description :
 */
object NeighborRepositoryImpl : NeighborRepository {
    override suspend fun getNeighborList(): List<NeighborModel> {
        return super.getNeighborList()
    }
}