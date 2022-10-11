package com.produtos.montaveis.ui.challenges

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.produtos.montaveis.data.ChallengeData
import com.produtos.montaveis.model.Challenge

class ChallengeViewModel : ViewModel() {

    private val _challengeList = MutableLiveData<List<Challenge>>()
    val challengeList: LiveData<List<Challenge>> = _challengeList

    private val _challenge = MutableLiveData<Challenge>()
    val challenge: LiveData<Challenge> = _challenge

    init {
        getChallengeData()
    }

    private fun getChallengeData() {
        _challengeList.value = ChallengeData.challenges
    }

    fun onChallengeClicked(challenge: Challenge) {
        _challenge.value = challenge
    }
}