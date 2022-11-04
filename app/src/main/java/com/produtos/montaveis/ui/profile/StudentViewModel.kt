package com.produtos.montaveis.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.produtos.montaveis.data.MockData
import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.model.Student

class StudentViewModel : ViewModel() {

    private val _student = MutableLiveData<Student>()
    val student: LiveData<Student> = _student

    private val _challenges = MutableLiveData<List<Challenge>>()
    val challenges: LiveData<List<Challenge>> = _challenges

    private val _challenge = MutableLiveData<Challenge>()
    val challenge: LiveData<Challenge> = _challenge

    private val _studentBadge = MutableLiveData<String>()
    val studentStatus: LiveData<String> = _studentBadge

    init {
        getStudent()
        determineStudentBadge()
    }

    fun onChallengeClicked(challenge: Challenge) {
        _challenge.value = challenge
    }

    private fun getStudent() {
        _student.value = MockData.student
        _student.value?.challenges.also {
            _challenges.value = it
        }
        /* Saving http requests
        viewModelScope.launch {
            try {
                _student.value = StudentApi.retrofitService.getStudent(1)
                _student.value?.challenges.also {
                    _challenges.value = it
                }
            } catch (_: Exception) {}
        }*/
    }

    private fun determineStudentBadge() {
        _studentBadge.value = when (_student.value?.level) {
            1 -> "Novato"
            2 -> "Aprendiz"
            3 -> "Dedicado"
            4 -> "Experiente"
            5 -> "Talentoso"
            else -> "Novato"
        }
    }
}