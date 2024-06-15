package com.example.triviaapp.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp.data.DataOrException
import com.example.triviaapp.model.QuestionItem
import com.example.triviaapp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository)
    : ViewModel() {
    val data: MutableState<DataOrException<ArrayList<QuestionItem>,
            Exception, Boolean>> = mutableStateOf(
                DataOrException(null,Exception(""),true)
            )

    init {
        getAllQuestion()
    }

    private fun getAllQuestion() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestion()
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
    }
    fun getTotalQuestionCount(): Int {
        return data.value.data?.toMutableList()?.size!!
    }
}