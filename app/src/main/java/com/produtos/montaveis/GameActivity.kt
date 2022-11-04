package com.produtos.montaveis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.produtos.montaveis.databinding.ActivityGameBinding
import com.produtos.montaveis.ui.game.FirstGameFragment
import com.produtos.montaveis.ui.game.GameResponseFragment

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    companion object {
        const val FORMULA_NAME = "formula"
        const val FORMULA_ID = "formulaId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val formulaId = getFormulaId(intent?.extras?.getString(FORMULA_NAME) ?: "")
        val bundle = bundleOf(FORMULA_ID to formulaId)

        when (formulaId) {
            1 -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<FirstGameFragment>(R.id.game_container_view)
                }
            }
            else -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<GameResponseFragment>(R.id.game_container_view, args = bundle)
                }
            }
        }
    }

    private fun getFormulaId(formula: String): Int {
        return when(formula) {
            "Quadrado da soma" -> 1
            "Quadrado da diferença" -> 2
            "Diferença de quadrados" -> 3
            "Cubo da soma" -> 4
            "Soma de cubos" -> 5
            "Cubo da diferença" -> 6
            else -> {
                7
            }
        }
    }
}