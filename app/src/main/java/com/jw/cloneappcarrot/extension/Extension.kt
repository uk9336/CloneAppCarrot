package com.jw.cloneappcarrot.extension

import android.transition.Fade
import android.transition.Transition
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
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

// Alpha Visible
fun View.fadeVisibility(visibility: Int, duration: Long = 400) {
    val transition: Transition = Fade()
    transition.duration = duration
    transition.addTarget(this)
    TransitionManager.beginDelayedTransition(this.parent as ViewGroup, transition)
    this.visibility = visibility
}