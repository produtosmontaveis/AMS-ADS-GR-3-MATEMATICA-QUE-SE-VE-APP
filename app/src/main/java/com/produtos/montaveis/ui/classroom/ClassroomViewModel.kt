package com.produtos.montaveis.ui.classroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.produtos.montaveis.data.MockData
import com.produtos.montaveis.model.Exercise
import com.produtos.montaveis.model.StudentAnswer
import java.time.OffsetDateTime

class ClassroomViewModel : ViewModel() {

    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>> = _exercises

    private val _exercise = MutableLiveData<Exercise>()
    val exercise: LiveData<Exercise> = _exercise

    init {
        getExercises()
    }

    private fun getExercises() {
        _exercises.value = MockData.exercises
    }

    fun getExercisesOnProgress(): List<Exercise>? {
        return _exercises.value?.filter { it.studentAnswer == null }
    }

    fun getExercisesDone(): List<Exercise>? {
        return _exercises.value?.filter { it.studentAnswer != null }
    }

    fun setExercise(exercise: Exercise) {
        _exercise.value = exercise
    }

    fun finishExercise(answer: String) {
        val studentAnswer = StudentAnswer(1, answer, OffsetDateTime.now().toString())
        _exercise.value?.id.let { exerciseId ->
            MockData.exercises.find {
                it.id == exerciseId
            }?.studentAnswer = studentAnswer
        }
        val studentScore = _exercise.value.let {
            if (it?.answer == it?.studentAnswer?.answer) it?.points ?: 0 else 0
        }
        MockData.student.score += studentScore
    }
}