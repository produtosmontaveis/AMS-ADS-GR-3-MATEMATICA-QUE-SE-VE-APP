package com.produtos.montaveis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.produtos.montaveis.databinding.ActivityGameBinding


class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    companion object {
        const val FORMULA_ID = "formulaId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
    }
}