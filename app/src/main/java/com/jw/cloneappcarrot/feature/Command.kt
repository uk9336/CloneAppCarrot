package com.jw.cloneappcarrot.feature

import android.view.View
import android.view.ViewGroup

/**
 * Created by LJW on 2022/01/11.
 *
 * Description :
 */
class Command constructor(
    val id: Int,
    val index: Int,
    val string: String,
    val view: View?,
) {

    constructor(builder: Builder) : this(
        builder.eventId, builder.index, builder.string, builder.view
    )

    class Builder(internal val eventId: Int) {
        internal var integer = 0    // int 설정
        internal var index = 0      // index 설정
        internal var string = ""    // string 설정
        internal var view : View? = null

        fun build() = Command(this)
    }


    /**************************
     * Constants
     *************************/
    companion object {

//        inline fun build(eventId: Int, block: Builder.() -> Unit): Command = Builder(
//            eventId
//        ).apply(block).build()

        const val MAIN_FAB_1 = 1
        const val MAIN_FAB_2 = 2
        const val MAIN_FAB_3 = 3
        const val MAIN_DIMENSION = 4

        const val HOME_ITEM = 100
    }
}