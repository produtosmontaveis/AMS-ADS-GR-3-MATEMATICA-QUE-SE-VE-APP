package com.produtos.montaveis.ui.challenges

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.produtos.montaveis.data.MockData
import com.produtos.montaveis.model.Challenge
import kotlinx.coroutines.launch

class ChallengeViewModel : ViewModel() {

    private val _challenges = MutableLiveData<List<Challenge>>()
    val challenges: LiveData<List<Challenge>> = _challenges

    private val _challenge = MutableLiveData<Challenge>()
    val challenge: LiveData<Challenge> = _challenge

    init {
        getChallenges()
    }

    fun onChallengeClicked(challenge: Challenge) {
        _challenge.value = challenge
    }

    private fun getChallenges() {
        viewModelScope.launch {
            try {
                _challenges.value = MockData.student.challenges
//                _challenges.value = ChallengeApi.retrofitService.getChallenges()
            } catch (_: Exception) {}
        }
    }

}