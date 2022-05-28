package com.jw.cloneappcarrot.model

/**
 * Created by LJW on 2022/05/27.
 *
 * Description :
 */
data class NeighborModel(
    val id: Int,
    val type: String,
    val nickName: String,
    val address: String,
    val content: String,
    val time: String,
    val imageUrl1: String,
    val imageUrl2: String,
    val imageUrl3: String,
    val good: Int,
    val reply: Int,
)

data class NeighborTypeModel(
    val type: String
)