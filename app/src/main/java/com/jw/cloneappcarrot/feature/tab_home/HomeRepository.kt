package com.jw.cloneappcarrot.feature.tab_home

import com.jw.cloneappcarrot.model.*

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
interface HomeRepository {

    suspend fun getHomeList(): List<JsonProduct> {
        return FakeProductList
    }
}