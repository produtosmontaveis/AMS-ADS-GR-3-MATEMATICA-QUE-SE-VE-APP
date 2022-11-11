package com.produtos.montaveis.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.produtos.montaveis.GameActivity
import com.produtos.montaveis.databinding.FragmentGameResponseBinding
import java.util.regex.Matcher
import java.util.regex.Pattern

class GameResponseFragment : Fragment() {

    private var _binding: FragmentGameResponseBinding? = null

    private val binding get() = _binding!!

    private val viewModel: GameViewModel by activityViewModels()

    private var formulaId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        formulaId = requireArguments().getInt(GameActivity.FORMULA_ID)
        _binding = FragmentGameResponseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getResponseBody(formulaId)
        viewModel.responseBody.observe(viewLifecycleOwner) {
            binding.responseText.text = it
            val pattern: Pattern = Pattern.compile("([^\"]*)")

            val matcher: Matcher = pattern.matcher(it.substring(16, 40))

            requireActivity().title = (if (matcher.find()) matcher.group(1) else TODO()).toString()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}