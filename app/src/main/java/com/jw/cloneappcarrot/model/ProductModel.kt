package com.jw.cloneappcarrot.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by LJW on 2021/12/04.
 *
 * Description :
 */

data class ProductInfo(
    @SerializedName("json_product")
    val productModel: JsonProduct,
) : Serializable

// 상품에 대한 데이터 모델
data class JsonProduct(
    val index: Int = 0,
    val userUid: String = "",
    val type: String = "",
    val image_url1: String = "",
    val image_url2: String = "",
    val image_url3: String = "",
    val image_url4: String = "",
    val image_url5: String = "",
    val title: String = "",
    val content: String = "",
    val neighbor: String = "",
    val category: String = "",
    val chat: String = "",
    val like: String = "",
    val time: String = "",
    val watch: String = "",
    val price: String = "",
    val json_user: JsonUser,
) : Serializable

// 유저 정보 데이터 모델
data class JsonUser(
    val userUid: String = "",
    val nickName: String = "",
    val profile_url: String = "",
    val neighbor: String = "",
    val temp: String = "",
) : Serializable

// 상품 이미지 리스트 데이터 모델
data class ProductImageModel(
    val image_url: String = "",
)