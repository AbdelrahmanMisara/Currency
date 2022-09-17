package com.blockgemini.currency.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.blockgemini.currency.databinding.ItemOtherBinding
import com.blockgemini.domain.models.Currency

class OtherAdapter :
    ListAdapter<Currency, OtherAdapter.OtherViewHolder>(OrderDiffCallback) {

    var onItemClick: (Currency) -> Unit = {}

    inner class OtherViewHolder(val binding: ItemOtherBinding) :
        RecyclerView.ViewHolder(binding.root)

    object OrderDiffCallback : DiffUtil.ItemCallback<Currency>() {
        override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
            return oldItem.symbol == newItem.symbol
        }

        override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
            return oldItem.symbol == newItem.symbol
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherViewHolder {
        return OtherViewHolder(
            ItemOtherBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OtherViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            currency = item
        }

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }


}