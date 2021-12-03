package com.jw.cloneappcarrot.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
object DataBindingUtil {

    // 내 동네 게시글 제목
    @BindingAdapter("home_title")
    @JvmStatic
    fun bindHomeTitle(tv: TextView, string: String) {
        tv.text = string
    }

    // 내 동네 게시글 동네명
    @BindingAdapter("home_neighbor")
    @JvmStatic
    fun bindHomeNeighbor(tv: TextView, string: String) {
        tv.text = string
    }

    // 내 동네 게시글 시간
    @BindingAdapter("home_time")
    @JvmStatic
    fun bindHomeTime(tv: TextView, string: String) {
        tv.text = string
    }

    // 내 동네 게시글 가격
    @BindingAdapter("home_price")
    @JvmStatic
    fun bindHomePrice(tv: TextView, string: String) {
        tv.text = string
    }

    // 내 동네 게시글 채팅 수
    @BindingAdapter("home_chat")
    @JvmStatic
    fun bindHomeChat(tv: TextView, string: String) {
        tv.text = string
    }

    // 내 동네 게시글 좋아요 수
    @BindingAdapter("home_life")
    @JvmStatic
    fun bindHomeLike(tv: TextView, string: String) {
        tv.text = string
    }
}