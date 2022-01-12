package com.jw.cloneappcarrot.feature

import android.view.View
import com.jw.cloneappcarrot.base.BaseViewModel

/**
 * Created by LJW on 2022/01/12.
 *
 * Description :
 */
class CommandInvoker(private val viewModel: BaseViewModel, private val builder: Command.Builder) {

    /**
     * int 설정
     */
    fun integer(value: Int): CommandInvoker {
        builder.integer = value
        return this
    }

    /**
     * index 설정
     */
    fun index(value: Int): CommandInvoker {
        builder.index = value
        return this
    }

    /**
     * string 설정
     */
    fun string(value: String): CommandInvoker {
        builder.string = value
        return this
    }

    /**
     * view 설정
     */
    fun view(value: View): CommandInvoker {
        builder.view = value
        return this
    }


    /**
     * 커맨드 실행
     */
    fun commit() {
        viewModel.onCommand(builder.build())
    }
}