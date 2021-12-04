package com.jw.cloneappcarrot.extension

import android.view.View
import com.jw.cloneappcarrot.common.OnSingleClickListener

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */


// 클릭리스너
fun View.setOnSingleClickListener(onSingleClick: (View) -> Unit) {
    val oneClick = OnSingleClickListener {
        onSingleClick(it)
    }
    setOnClickListener(oneClick)
}