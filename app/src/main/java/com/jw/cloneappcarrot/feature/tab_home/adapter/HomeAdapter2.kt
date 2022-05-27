package com.jw.cloneappcarrot.feature.tab_home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.databinding.ItemHomeAdBinding
import com.jw.cloneappcarrot.databinding.ItemHomeBinding
import com.jw.cloneappcarrot.feature.tab_home.HomeViewModel
import com.jw.cloneappcarrot.model.JsonProduct

/**
 * Created by LJW on 2022/01/11.
 *
 * Description :
 */
class HomeAdapter2(val viewModel: HomeViewModel) :
    RecyclerView.Adapter<AbstractHomeViewHolder<*>>() {

    var items: List<JsonProduct>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractHomeViewHolder<*> {
        return if (viewType == 0) HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        )
        else HomeAdViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_ad, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return items?.let {
            it[position].let { it1 ->
                when (it1.type) {
                    "sale" -> 0
                    else -> 1
                }
            }
        } ?: 0
    }

    override fun onBindViewHolder(holder: AbstractHomeViewHolder<*>, position: Int) {
        items?.let {
            it[position].let { it1 ->
                when (holder) {
                    is HomeViewHolder -> {
                        holder.binding.view = holder.binding.cardView
                        holder.binding.index = position
                        holder.binding.model = it1
                        holder.binding.viewModel = viewModel
                        holder.binding.lifecycleOwner = viewModel.lifecycleOwner
                    }
                    is HomeAdViewHolder -> {
                        holder.binding.model = it1
                    }
                }
            }
        }
    }
}

// ViewHolder Abstract 클래스
abstract class AbstractHomeViewHolder<T : ViewDataBinding>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    lateinit var binding: T
}

// 판매 아이템 ViewHolder
class HomeViewHolder(itemView: View) : AbstractHomeViewHolder<ItemHomeBinding>(itemView) {
    init {
        binding = DataBindingUtil.bind(itemView)!!
    }
}

// 광고 아이템 ViewHolder
class HomeAdViewHolder(itemView: View) : AbstractHomeViewHolder<ItemHomeAdBinding>(itemView) {
    init {
        binding = DataBindingUtil.bind(itemView)!!
    }
}