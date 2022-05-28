package com.jw.cloneappcarrot.feature.tab_neighbor.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jw.cloneappcarrot.databinding.ItemNeighborTypeBinding
import com.jw.cloneappcarrot.extension.setOnSingleClickListener
import com.jw.cloneappcarrot.feature.tab_neighbor.neighbor_type.NeighborTypeActivity
import com.jw.cloneappcarrot.model.NeighborTypeModel

/**
 * Created by LJW on 2022/05/28.
 *
 * Description :
 */
class NeighborTypeAdapter(val items: List<NeighborTypeModel>) :
    RecyclerView.Adapter<NeighborTypeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemNeighborTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: NeighborTypeModel) {
            binding.model = model
            itemView.setOnSingleClickListener {
                val i = Intent(itemView.context, NeighborTypeActivity::class.java)
                i.putExtra("type", model.type)
                itemView.context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemNeighborTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}