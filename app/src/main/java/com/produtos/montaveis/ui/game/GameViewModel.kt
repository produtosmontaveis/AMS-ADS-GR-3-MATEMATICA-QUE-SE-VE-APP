package com.produtos.montaveis.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.produtos.montaveis.data.MockData
import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.network.FormulaApi
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private val _responseBody = MutableLiveData<String>()
    val responseBody: LiveData<String> = _responseBody

    private val _challenge = MutableLiveData<Challenge>()
    val challenge: LiveData<Challenge> = _challenge

    private val _challengeProgressStatus = MutableLiveData<Double>()
    val challengeProgressStatus: LiveData<Double> = _challengeProgressStatus

    init {
        _challengeProgressStatus.value = 0.0
    }

    fun getResponseBody(formulaId: Int) {
        viewModelScope.launch {
            try {
                _responseBody.value = FormulaApi.retrofitService.getFormula(formulaId)
            } catch (e: Exception) {
                _responseBody.value = e.message
            }
        }
    }

    fun getChallenge(formulaId: Int) {
        viewModelScope.launch {
            try {
                _challenge.value = MockData.student.challenges?.find { it.formula.id == formulaId }
//                _challenge.value = ChallengeApi.retrofitService.getChallenge(formulaId)
            } catch (_: Exception) {}
        }
    }

    fun updateChallenge() {
        _challengeProgressStatus.value = _challengeProgressStatus.value?.plus(25.0)
    }

    fun finishChallenge() {
        viewModelScope.launch {
            try {
                _challenge.value?.formula?.id?.let { formulaId ->
                    MockData.student.challenges?.find { it.formula.id == formulaId }?.progressStatus = 100.0
                //                    ChallengeApi.retrofitService.finishChallenge(formulaId)
                }
            } catch (_: Exception) {}
        }
    }
}