package com.produtos.montaveis.ui.classroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.produtos.montaveis.R
import com.produtos.montaveis.data.MockData
import com.produtos.montaveis.databinding.FragmentClassroomBinding

class ClassroomFragment : Fragment() {

    private var _binding: FragmentClassroomBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ClassroomViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClassroomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ExerciseAdapter {
            viewModel.setExercise(it)
        }
        binding.rvExercises.adapter = adapter

        binding.toolbar.title = "Oi, ${MockData.student.name}"

        viewModel.exercises.observe(viewLifecycleOwner) {
            adapter.submitList(viewModel.getExercisesOnProgress())
            binding.exercisesOnProgress.text = viewModel.getExercisesOnProgress()?.size.toString()
            binding.exercisesDone.text = viewModel.getExercisesDone()?.size.toString()
        }

        binding.exercisesOnProgressLabel.setOnClickListener {
            adapter.submitList(viewModel.getExercisesOnProgress())
            binding.exercisesDoneBar.visibility = View.INVISIBLE
            binding.exercisesOnProgressBar.visibility = View.VISIBLE
            binding.exercisesOnProgressLabel.setTextAppearance(R.style.Widget_ProdutosMontaveis_TextViewFocused)
            binding.exercisesDoneLabel.setTextAppearance(R.style.Widget_ProdutosMontaveis_TextViewUnfocused)
        }

        binding.exercisesDoneLabel.setOnClickListener {
            adapter.submitList(viewModel.getExercisesDone())
            binding.exercisesDoneBar.visibility = View.VISIBLE
            binding.exercisesOnProgressBar.visibility = View.INVISIBLE
            binding.exercisesOnProgressLabel.setTextAppearance(R.style.Widget_ProdutosMontaveis_TextViewUnfocused)
            binding.exercisesDoneLabel.setTextAppearance(R.style.Widget_ProdutosMontaveis_TextViewFocused)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}