package com.example.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basic.controller.EventExampleManager
import com.example.basic.controller.MiniCalculatorManager
import com.example.basic.controller.QuestionManager
import com.example.basic.controller.TicTacToeManager
import com.example.basic.databinding.*


class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (intent.getStringExtra(view)) {
            question -> {
                val binding = DynamicLayoutExampleBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
                QuestionManager(this, binding.quizContainer).initQuestionManager()
            }
            eventExample -> {
                val binding = ActivityEventExampleBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
                EventExampleManager(this, binding).initEventExampleManager()
            }
            miniCalculator -> {
                val binding = ActivityMiniCalculatorBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
                MiniCalculatorManager(this, binding).initMiniCalculatorManager()
            }
            example1 -> {
                val binding = BasicConstraintLayoutPracticeBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
            }
            example2 -> {
                val binding = ConstrainLayoutPracticeBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
            }
            ticTacToeGame -> {
                val binding = ActivityTickTacToeBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
                TicTacToeManager(this, binding).initTicTacToeManager()
            }
            else -> {
                val binding = ActivityViewBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
            }
        }

    }
}