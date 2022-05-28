package com.jw.cloneappcarrot.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
object DatabindingUtil {

    // url 있으면 url load, 없으면 placeholder 나 errorHolder load
    @BindingAdapter(value = ["srcUrl", "inside", "placeholder", "errorHolder"], requireAll = false)
    @JvmStatic
    fun bindSrcUrl(
        imageView: ImageView,
        url: String?,
        inside: Boolean = false,
        placeholder: Drawable?,
        errorHolder: Drawable?
    ) {
        Glide.with(imageView.context).let { glide ->
            url.takeIf { !it.isNullOrEmpty() }?.let {
                glide.load(it).also {
                    placeholder?.run { it.placeholder(this) }
                }
            } ?: run {
                (placeholder ?: errorHolder)?.let {
                    glide.load(it)
                }
            }
        }?.let {
            if (inside) it.centerInside() else it.centerCrop()
        }?.into(imageView)
    }

    // String
    @BindingAdapter("string")
    @JvmStatic
    fun bindString(tv:TextView, string: String){
        tv.text = string
    }
}