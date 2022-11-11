package com.produtos.montaveis.ui.challenges

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.produtos.montaveis.GameActivity
import com.produtos.montaveis.databinding.FragmentChallengeListBinding

class ChallengeListFragment : Fragment() {

    private var _binding: FragmentChallengeListBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ChallengeViewModel by activityViewModels()

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
            viewModel.startChallenge(it)
            val intent = Intent(requireActivity(), GameActivity::class.java)
            intent.putExtra(GameActivity.FORMULA_NAME, it.formula.name)
            requireActivity().startActivity(intent)
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

