package com.example.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basic.controller.*
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
            fragmentIntroduction -> {
                val binding = FragmentIntroductionBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
                FragmentIntroductionManager(this).initFragmentIntroductionManager()
            }
            fragmentManagerIntro -> {
                val binding = FragmentManagerIntroBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
                FragmentManagerIntroduction(this, binding).initFragmentManagerIntroductionManager()
            }
            fragmentInteraction -> {
                val binding = FragmentInteractionLayoutBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
                FragmentInteractionManager(this, binding).initFragmentInteractionManager()
            }
            fragmentNavigation -> {
                val binding = FragmentNavigationBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
                FragmentNavigationManager(this, binding).initFragmentNavigationManager()
            }
            implicitIntent -> {
                val binding = ImplicitIntentExampleBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
                ImplicitIntentExampleManager(this, binding).initImplicitIntentManager()
            }
            else -> {
                val binding = ActivityViewBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
            }
        }

    }
}