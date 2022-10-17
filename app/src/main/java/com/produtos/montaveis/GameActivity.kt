package com.produtos.montaveis

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.produtos.montaveis.databinding.ActivityGameBinding
import com.produtos.montaveis.ui.game.GameViewModel


class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    private val viewModel: GameViewModel by viewModels()

    companion object {
        const val FORMULA_NAME = "formulaId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val formula = intent?.extras?.getString(FORMULA_NAME) ?: ""

        viewModel.getResponseBody(formula)
        viewModel.responseBody.observe(this) {
            binding.textView.text = it
        }
    }
}