package com.example.triviaapp.repository

import android.util.Log
import com.example.triviaapp.data.DataOrException
import com.example.triviaapp.model.QuestionItem
import com.example.triviaapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi
) {
    private val dataOrException
    = DataOrException<ArrayList<QuestionItem>,
            Exception,
            Boolean>()

    suspend fun getAllQuestion(): DataOrException<ArrayList<QuestionItem>,Exception,Boolean> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exception", "getAllQuestion: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}