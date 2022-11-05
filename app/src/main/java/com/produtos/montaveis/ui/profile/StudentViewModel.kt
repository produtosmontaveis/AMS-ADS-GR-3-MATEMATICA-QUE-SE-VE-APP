package com.produtos.montaveis.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.produtos.montaveis.data.MockData
import com.produtos.montaveis.model.Badge
import com.produtos.montaveis.model.Student

class StudentViewModel : ViewModel() {

    private val _student = MutableLiveData<Student>()
    val student: LiveData<Student> = _student

    private val _rank = MutableLiveData<String>()
    val rank: LiveData<String> = _rank

    private val _badges = MutableLiveData<List<Badge>>()
    val badges: LiveData<List<Badge>> = _badges

    init {
        getStudent()
        determineStudentRank()
    }

    private fun getStudent() {
        try {
            _student.value = MockData.student

        } catch (_: Exception) {
        }
        /* Saving http requests
        viewModelScope.launch {
            try {
                _student.value = StudentApi.retrofitService.getStudent(1)
            } catch (_: Exception) {}
        }*/
    }

    fun updateBadges() {
        val badgesList = mutableListOf<Badge>()

        _student.value?.challenges?.forEach {
            badgesList.add(
                Badge(
                    it.formula.name,
                    it.badgeUrl,
                    it.progressStatus == 100.0
                )
            )
        }
        _badges.value = badgesList
    }

    private fun determineStudentRank() {
        _rank.value = when (_student.value?.level) {
            1 -> "Novato"
            2 -> "Aprendiz"
            3 -> "Dedicado"
            4 -> "Experiente"
            5 -> "Talentoso"
            else -> "Novato"
        }
    }
}