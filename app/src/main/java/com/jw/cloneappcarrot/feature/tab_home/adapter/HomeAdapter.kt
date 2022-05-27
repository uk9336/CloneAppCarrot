package com.jw.cloneappcarrot.feature.tab_home.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jw.cloneappcarrot.databinding.ItemHomeBinding
import com.jw.cloneappcarrot.extension.setOnSingleClickListener
import com.jw.cloneappcarrot.feature.product.ProductActivity
import com.jw.cloneappcarrot.model.JsonProduct

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
class HomeAdapter(
    private val items: List<JsonProduct>,
    private val activity: Activity
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    // ViewHolder Class
     inner class ViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(info: JsonProduct) {
            binding.model = info
            val context = itemView.context
            // 아이템 클릭
            binding.itemLayout.setOnSingleClickListener {

                // 상품 정보보기 화면으로 이동
                val i = Intent(context, ProductActivity::class.java)
                val options =
                    ActivityOptions.makeSceneTransitionAnimation(
                        activity,
                        binding.cardView,
                        "image_transform"
                    )
                i.putExtra("info", info)
                context.startActivity(
                    i,
                    options.toBundle()
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        Glide.with(activity)
            .load(items[position].image_url1)
            .into(holder.binding.itemIv)
    }
}