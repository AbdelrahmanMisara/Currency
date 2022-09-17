package com.blockgemini.currency.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.blockgemini.currency.databinding.ItemHistoricalBinding
import com.blockgemini.domain.models.Rate

class HistoryAdapter :
    ListAdapter<Rate, HistoryAdapter.HistoryViewHolder>(OrderDiffCallback) {

    var onItemClick: (Rate) -> Unit = {}

    inner class HistoryViewHolder(val binding: ItemHistoricalBinding) :
        RecyclerView.ViewHolder(binding.root)

    object OrderDiffCallback : DiffUtil.ItemCallback<Rate>() {
        override fun areItemsTheSame(oldItem: Rate, newItem: Rate): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: Rate, newItem: Rate): Boolean {
            return oldItem.date == newItem.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoricalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            rate = item
        }

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }


}