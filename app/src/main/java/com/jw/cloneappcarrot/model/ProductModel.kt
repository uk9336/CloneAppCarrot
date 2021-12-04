package com.jw.cloneappcarrot.model

import com.google.gson.annotations.SerializedName

/**
 * Created by LJW on 2021/12/04.
 *
 * Description :
 */

data class ProductInfo(
    @SerializedName("json_product")
    val productModel: json_product,
    @SerializedName("json_user")
    val userModel: json_user
)

// 상품에 대한 데이터 모델
data class json_product(
    val index: String,
    val userUid: String,
    val image_url1: String,
    val image_url2: String,
    val image_url3: String,
    val image_url4: String,
    val image_url5: String,
    val title: String,
    val content: String,
    val category: String,
    val chat: String,
    val like: String,
    val time: String,
    val watch: String
)

// 유저 정보 데이터 모델
data class json_user(
    val userUid: String,
    val nickName: String,
    val profile_url: String,
    val neighbor: String,
    val temp: String,
)

// 상품 이미지 리스트 데이터 모델
data class ProductImageModel(
    val image_url: String,
)