package com.example.layoutbasicexamples.model

enum class QuestionType{
    Text,
    Radio,
    CheckBox
}

data class Question(val id: Int, val type: QuestionType, val qText: String, val options: List<String>?,
                    val answers: List<String>)