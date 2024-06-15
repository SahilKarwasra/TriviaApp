package com.example.triviaapp.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviaapp.component.Questions

@Composable
fun TriviaHome(
    viewModel: QuestionViewModel = hiltViewModel()
) {
    Questions(viewModel)
}

