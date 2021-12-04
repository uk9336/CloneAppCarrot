package com.jw.cloneappcarrot.common

import android.os.SystemClock
import android.view.View

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
class OnSingleClickListener(
    private var interval: Int = 600,
    private var onSingleClick: (View) -> Unit
) : View.OnClickListener {

    private var lastClickTime: Long = 0

    override fun onClick(v: View) {
        val elapsedRealtime = SystemClock.elapsedRealtime()
        if ((elapsedRealtime - lastClickTime) < interval) return
        lastClickTime = elapsedRealtime
        onSingleClick(v)
    }
}