package com.produtos.montaveis.ui.challenges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.produtos.montaveis.R
import com.produtos.montaveis.databinding.FragmentChallengeListBinding
import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.model.ChallengeViewModel

private const val CHALLENGE_LIST_FRAGMENT = "ChallengeListFragment"

class ChallengeListFragment : Fragment() {

    private var _binding: FragmentChallengeListBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ChallengeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChallengeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ChallengeAdapter(ChallengeListener {
            viewModel.onChallengeClicked(it)
            findNavController().navigate(R.id.action_challengeListFragment_to_challengeDetailFragment)
//            redirectToGameActivity(it)
            Toast.makeText(requireContext(), it.formula.name, Toast.LENGTH_LONG).show()
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

    /*
    * Given the challenge, it's possible to get the corresponding formula to build the game
    *
    * @param { Challenge } challenge
    *
    */
    private fun redirectToGameActivity(challenge: Challenge) {
        TODO("Challenges not implemented yet")
        /* Possible implementation
            val intent = Intent(requireActivity(), GameActivity::class.java)
            intent.putExtra("formula", formulaId)
            startActivity(intent)
        */
    }
}

