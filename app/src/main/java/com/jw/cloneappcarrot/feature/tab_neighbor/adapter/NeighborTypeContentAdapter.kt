package com.jw.cloneappcarrot.feature.tab_neighbor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jw.cloneappcarrot.databinding.ItemNeighborTypeContentBinding
import com.jw.cloneappcarrot.model.NeighborModel

/**
 * Created by LJW on 2022/05/30.
 *
 * Description : 필터별 동네생활 글 목록 리사이클러뷰 어뎁터
 */
class NeighborTypeContentAdapter(val items: List<NeighborModel>) : RecyclerView.Adapter<NeighborTypeContentAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemNeighborTypeContentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(info: NeighborModel) {
            binding.model = info
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNeighborTypeContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}