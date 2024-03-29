package com.produtos.montaveis.ui.challenges

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.produtos.montaveis.databinding.ChallengeItemBinding
import com.produtos.montaveis.model.Challenge

class ChallengeAdapter(private val clickListener: ChallengeListener) :
    ListAdapter<Challenge, ChallengeAdapter.ChallengeViewHolder>(DiffCallback) {

    class ChallengeViewHolder(private var binding: ChallengeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val formula = binding.challengeName
        fun bind(clickListener: ChallengeListener, challenge: Challenge) {
            binding.clickListener = clickListener
            binding.challenge = challenge
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
        holder.itemView.setOnClickListener {
            val action =
                ChallengeListFragmentDirections
                    .actionChallengeListFragmentToChallengeDetailFragment(formulaId = challenge.formula.id)
            holder.itemView.findNavController().navigate(action)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Challenge>() {
        override fun areItemsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
            return oldItem.formula.id == newItem.formula.id
        }

        override fun areContentsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
            return oldItem == newItem
        }
    }
}

class ChallengeListener(val clickListener: (Challenge) -> Unit) {
    fun onClick(challenge: Challenge) = clickListener(challenge)
}