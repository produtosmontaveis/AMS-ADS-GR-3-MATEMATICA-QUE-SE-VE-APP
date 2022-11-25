package com.produtos.montaveis.ui.classroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.produtos.montaveis.data.MockData
import com.produtos.montaveis.model.Exercise

class ClassroomViewModel : ViewModel() {

    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>> = _exercises

    init {
        getExercises()
    }

    private fun getExercises() {
        _exercises.value = MockData.exercises
    }

    fun getExercisesOnProgress(): List<Exercise>? {
        return _exercises.value?.filter { it.response == null }
    }

    fun getExercisesDone(): List<Exercise>? {
        return _exercises.value?.filter { it.response != null }
    }
}