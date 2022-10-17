package com.produtos.montaveis.ui.challenges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.produtos.montaveis.R
import com.produtos.montaveis.StudentViewModel
import com.produtos.montaveis.databinding.FragmentChallengeListBinding

private const val CHALLENGE_LIST_FRAGMENT = "ChallengeListFragment"

class ChallengeListFragment : Fragment() {

    private var _binding: FragmentChallengeListBinding? = null

    private val binding get() = _binding!!

    private val viewModel: StudentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChallengeListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ChallengeAdapter(ChallengeListener {
            viewModel.onChallengeClicked(it)
            findNavController().navigate(R.id.action_challengeListFragment_to_challengeDetailFragment)
        })

        viewModel.challenges.observe(viewLifecycleOwner) { challenges ->
            challenges.let { adapter.submitList(it) }
        }

        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

