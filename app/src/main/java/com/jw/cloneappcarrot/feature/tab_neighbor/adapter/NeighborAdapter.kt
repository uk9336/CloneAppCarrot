package com.jw.cloneappcarrot.feature.tab_neighbor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jw.cloneappcarrot.databinding.ItemNegiborBinding
import com.jw.cloneappcarrot.model.NeighborModel

/**
 * Created by LJW on 2022/05/28.
 *
 * Description : 동네생활 글 리사이클러뷰 어뎁터
 */
class NeighborAdapter(
    private val items: List<NeighborModel>,
) : RecyclerView.Adapter<NeighborAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemNegiborBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(info: NeighborModel) {
            binding.model = info
            val context = itemView.context
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNegiborBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size
}