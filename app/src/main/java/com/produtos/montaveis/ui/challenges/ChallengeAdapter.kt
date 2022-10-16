package com.produtos.montaveis.ui.challenges

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.produtos.montaveis.GameActivity
import com.produtos.montaveis.databinding.ChallengeItemBinding
import com.produtos.montaveis.model.Challenge

class ChallengeAdapter(val clickListener: ChallengeListener) :
    ListAdapter<Challenge, ChallengeAdapter.ChallengeViewHolder>(DiffCallback) {

    class ChallengeViewHolder(private var binding: ChallengeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val startChallengeButton = binding.startButton
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
        holder.startChallengeButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, GameActivity::class.java)
            intent.putExtra(GameActivity.FORMULA_ID, challenge.formula.id)
            context.startActivity(intent)
        }
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