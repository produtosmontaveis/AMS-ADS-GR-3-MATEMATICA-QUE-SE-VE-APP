package com.produtos.montaveis.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.produtos.montaveis.data.MockData
import com.produtos.montaveis.model.Badge
import com.produtos.montaveis.model.Student
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {

    private val _student = MutableLiveData<Student>()
    val student: LiveData<Student> = _student

    private val _rank = MutableLiveData<String>()
    val rank: LiveData<String> = _rank

    private val _badges = MutableLiveData<List<Badge>>()
    val badges: LiveData<List<Badge>> = _badges

    init {
        getProfileData()
    }

    private fun getProfileData() {
        viewModelScope.launch {
            try {
//                _student.value = StudentApi.retrofitService.getStudent(1)
                _student.value = MockData.student
                getBadges()
                determineStudentRank()
            } catch (_: Exception) {}
        }
    }

    private fun getBadges() {
        val badgesList = mutableListOf<Badge>()

        _student.value?.challenges?.forEach {
            badgesList.add(
                Badge(
                    it.formula.id,
                    it.formula.name,
                    it.formula.badgeImageUrl,
                    it.progressStatus == 100.0
                )
            )
        }
        badgesList.sortBy { it.id }
        _badges.value = badgesList
    }

    private fun determineStudentRank() {
        _rank.value = when (_student.value?.level) {
            0 -> "Novato"
            1 -> "Aprendiz"
            2 -> "Dedicado"
            3 -> "Experiente"
            4 -> "Talentoso"
            5 -> "Proeficiente"
            6 -> "Mestre"
            else -> "Novato"
        }
    }
}