package com.produtos.montaveis.ui.challenges

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.produtos.montaveis.data.ChallengeData
import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.network.ChallengeApi
import kotlinx.coroutines.launch

class ChallengeViewModel : ViewModel() {

    private val _challenges = MutableLiveData<List<Challenge>>()
    val challenges: LiveData<List<Challenge>> = _challenges

    private val _challenge = MutableLiveData<Challenge>()
    val challenge: LiveData<Challenge> = _challenge

    init {
        getChallengeData()
    }

    private fun getChallengeData() {
        viewModelScope.launch {
            try {
                _challenges.value = ChallengeApi.retrofitService.getChallenges(1)
            } catch (e: Exception) {
                println(e.message)
                _challenges.value = ChallengeData.challenges
            }
        }
    }

    fun onChallengeClicked(challenge: Challenge) {
        _challenge.value = challenge
    }
}