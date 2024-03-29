package com.produtos.montaveis.ui.challenges

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.produtos.montaveis.data.MockData
import com.produtos.montaveis.model.Challenge
import kotlinx.coroutines.launch

private const val TAG = "ChallengeViewModel"

class ChallengeViewModel : ViewModel() {

    private val _challenges = MutableLiveData<List<Challenge>>()
    val challenges: LiveData<List<Challenge>> = _challenges

    private val _challenge = MutableLiveData<Challenge>()
    val challenge: LiveData<Challenge> = _challenge

    init {
        getChallenges()
    }

    fun getChallenge(formulaId: Int) {
        _challenge.value = _challenges.value?.find {
            it.formula.id == formulaId
        }
    }

    private fun getChallenges() {
        viewModelScope.launch {
            try {
//                _challenges.value = ChallengeApi.retrofitService.getChallenges()
                _challenges.value = MockData.student.challenges.orEmpty()
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
            }
        }
    }

    fun startChallenge(challenge: Challenge) {
        _challenge.value = challenge

        viewModelScope.launch {
            try {
//                if (challenge.startDateTime == null) {
//                    ChallengeApi.retrofitService.startChallenge(challenge.formula.id)
//                }
            } catch (_: Exception) {
            }
        }
    }
}