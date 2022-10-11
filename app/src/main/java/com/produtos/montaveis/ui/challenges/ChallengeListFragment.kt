package com.produtos.montaveis.ui.challenges

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.produtos.montaveis.adapter.ChallengeAdapter
import com.produtos.montaveis.adapter.ChallengeListener
import com.produtos.montaveis.data.ChallengeData.challenges
import com.produtos.montaveis.databinding.FragmentChallengeListBinding

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
//            redirectToGameActivity(it.formula.id)
            Log.d(CHALLENGE_LIST_FRAGMENT, it.toString())
            Toast.makeText(requireContext(), it.formula.name, Toast.LENGTH_LONG).show()
        })

        viewModel.challengeList.observe(viewLifecycleOwner) { challenges ->
            challenges.let { adapter.submitList(it) }
        }

        binding.recyclerView.adapter = adapter
    }

    /*
    * Given the id of the formula, redirects to the corresponding challenge
    *
    * @param { Int } formulaId
    *
    */
    private fun redirectToGameActivity(formulaId: Int) {
        TODO("Challenges not implemented yet")
        /* Possible implementation
            val intent = Intent(requireActivity(), GameActivity::class.java)
            intent.putExtra("formula", formulaId)
            startActivity(intent)
        */
    }
}

