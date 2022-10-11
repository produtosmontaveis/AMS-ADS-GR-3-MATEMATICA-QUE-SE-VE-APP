package com.produtos.montaveis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.produtos.montaveis.R
import com.produtos.montaveis.databinding.ChallengeItemBinding
import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.model.getFormattedProgressStatus

class ChallengeAdapter(val clickListener: ChallengeListener) :
    ListAdapter<Challenge, ChallengeAdapter.ChallengeViewHolder>(DiffCallback) {

    class ChallengeViewHolder(private var binding: ChallengeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: ChallengeListener, challenge: Challenge) {
            binding.clickListener = clickListener
            binding.challenge = challenge
            binding.progressStatus.text = challenge.getFormattedProgressStatus()
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        return ChallengeViewHolder(
            ChallengeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        val challenge = getItem(position)
        holder.bind(clickListener, challenge)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Challenge>() {
        override fun areItemsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
            return oldItem.formula.id == newItem.formula.id
                    && oldItem.studentId == newItem.studentId
        }

        override fun areContentsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
            return oldItem == newItem
        }
    }
}

class ChallengeListener(val clickListener: (Challenge) -> Unit) {
    fun onClick(challenge: Challenge) = clickListener(challenge)
}