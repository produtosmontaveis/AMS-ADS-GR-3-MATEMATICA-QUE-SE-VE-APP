package com.produtos.montaveis.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.produtos.montaveis.data.ChallengeData
import com.produtos.montaveis.model.Student
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val _student = MutableLiveData<Student>()
    val student: LiveData<Student> = _student

    private val _studentBadge = MutableLiveData<String>()
    val studentStatus: LiveData<String> = _studentBadge

    init {
        getStudentProfile()
        determineStudentBadge()
    }

    private fun getStudentProfile() {
        viewModelScope.launch {
            _student.value = ChallengeData.student
        }
    }

    private fun determineStudentBadge() {
        _studentBadge.value = when (_student.value?.level) {
            1 -> "Novato"
            2 -> "Aprendiz"
            3 -> "Dedicado"
            4 -> "Experiente"
            5 -> "Talentoso"
            else -> "Proeficiente"
        }
    }
}