package com.produtos.montaveis.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.produtos.montaveis.databinding.BadgeItemBinding
import com.produtos.montaveis.model.Badge

class BadgeAdapter : ListAdapter<Badge, BadgeAdapter.BadgeViewHolder>(DiffCallback) {

    class BadgeViewHolder(private var binding: BadgeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(badge: Badge) {
            binding.badge = badge
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BadgeViewHolder {
        return BadgeViewHolder(
            BadgeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BadgeViewHolder, position: Int) {
        val badge = getItem(position)
        holder.bind(badge)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Badge>() {
        override fun areItemsTheSame(oldItem: Badge, newItem: Badge): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Badge, newItem: Badge): Boolean {
            return oldItem == newItem
        }
    }
}