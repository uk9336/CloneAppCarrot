package com.jw.cloneappcarrot.feature.product

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jw.cloneappcarrot.common.Dlog
import com.jw.cloneappcarrot.databinding.ItemProductImageBinding
import com.jw.cloneappcarrot.model.ProductImageModel

/**
 * Created by LJW on 2021/12/04.
 *
 * Description : 삼품보기 이미지 뷰페이저 어뎁터
 */
class ProductAdapter(
    private val items: List<ProductImageModel>,
    private val activity: Activity
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemProductImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ProductImageModel) {
            binding.model = model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemProductImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        // 이미지 보여주기
        Glide.with(activity)
            .load(items[position].image_url)
            .into(holder.binding.productIv)
    }

    override fun getItemCount(): Int {
        Dlog.d("size => ${items.size}")
        return items.size
    }
}