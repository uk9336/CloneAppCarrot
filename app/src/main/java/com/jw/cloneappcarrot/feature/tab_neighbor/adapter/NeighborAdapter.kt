package com.jw.cloneappcarrot.feature.tab_neighbor.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jw.cloneappcarrot.databinding.ItemNegiborBinding
import com.jw.cloneappcarrot.model.JsonProduct
import com.jw.cloneappcarrot.model.NeighborModel

/**
 * Created by LJW on 2022/05/28.
 *
 * Description :
 */
class NeighborAdapter(
    private val items: List<NeighborModel>,
    private val activity: Activity
) : RecyclerView.Adapter<NeighborAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemNegiborBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(info: JsonProduct) {
            val context = itemView.context
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNegiborBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size
}