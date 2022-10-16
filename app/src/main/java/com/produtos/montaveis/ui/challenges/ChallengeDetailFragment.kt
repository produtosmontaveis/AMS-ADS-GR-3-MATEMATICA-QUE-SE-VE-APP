package com.produtos.montaveis.ui.challenges

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.produtos.montaveis.R
import com.produtos.montaveis.databinding.FragmentChallengeDetailBinding
import com.produtos.montaveis.databinding.FragmentChallengeListBinding
import com.produtos.montaveis.databinding.FragmentProfileBinding
import com.produtos.montaveis.model.ChallengeViewModel

class ChallengeDetailFragment : Fragment() {


    private var _binding: FragmentChallengeDetailBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ChallengeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChallengeDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}