package com.example.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basic.controller.QuestionManager
import com.example.basic.databinding.ActivityViewBinding
import com.example.basic.databinding.DynamicLayoutExampleBinding


class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = intent.getStringExtra(view)

        if (v == question) {
            val binding = DynamicLayoutExampleBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
            QuestionManager(this, binding.quizContainer).initQuestionManager()
        } else {
            val binding = ActivityViewBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
        }

    }
}