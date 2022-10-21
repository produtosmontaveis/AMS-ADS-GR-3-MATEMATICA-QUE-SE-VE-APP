package com.produtos.montaveis.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.network.FormulaApi
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                FormulaApi.retrofitService.getFormula(formulaId)
                    .enqueue(object: Callback<ResponseBody> {
                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {
                            _responseBody.value = response.body()?.string()
                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        }

                    })
            } catch (_:Exception) { }
        }
    }

    fun updateChallenge() {
        _challengeProgressStatus.value = _challengeProgressStatus.value?.plus(25.0)
    }
}