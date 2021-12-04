package com.jw.cloneappcarrot.feature.tab_home

import com.jw.cloneappcarrot.model.HomeModel

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
object HomeRepositoryImpl : HomeRepository {

    // 내 동네 게시글 리스트
    override suspend fun getHomeList(): List<HomeModel> {
        return super.getHomeList()
    }
}