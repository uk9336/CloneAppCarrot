package com.jw.cloneappcarrot.feature.tab_home

import com.jw.cloneappcarrot.model.HomeModel
import com.jw.cloneappcarrot.model.fakeHomeList

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
interface HomeRepository {

    suspend fun getHomeList(): List<HomeModel> {
        return fakeHomeList
    }
}