package com.jw.cloneappcarrot.feature.tab_home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jw.cloneappcarrot.databinding.ItemHomeBinding
import com.jw.cloneappcarrot.extension.setOnSingleClickListener
import com.jw.cloneappcarrot.model.HomeModel

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
class HomeAdapter(
    private val items: List<HomeModel>
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    // ViewHolder Class
    class ViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(info: HomeModel) {
            binding.model = info

            // 아이템 클릭
            binding.itemLayout.setOnSingleClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}