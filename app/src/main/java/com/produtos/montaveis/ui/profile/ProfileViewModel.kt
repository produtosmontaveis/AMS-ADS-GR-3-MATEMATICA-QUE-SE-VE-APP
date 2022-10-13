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

    init {
        getStudentProfile()
    }

    private fun getStudentProfile() {
        viewModelScope.launch {
            _student.value = ChallengeData.student
        }
    }
}