package com.produtos.montaveis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.produtos.montaveis.databinding.ActivityGameBinding
import com.produtos.montaveis.model.ChallengeViewModel


class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    private val viewModel: ChallengeViewModel by viewModels()

    companion object {
        const val FORMULA_ID = "formulaId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
    }
}