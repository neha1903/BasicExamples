package com.example.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basic.controller.QuestionManager
import com.example.basic.databinding.DynamicLayoutExampleBinding

private lateinit var binding: DynamicLayoutExampleBinding


class QuestionActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DynamicLayoutExampleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        QuestionManager(this, binding.quizContainer).initQuestionManager()
    }

}