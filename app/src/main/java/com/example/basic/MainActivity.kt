package com.example.basic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basic.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

const val view = "VIEW"
const val question = "QUESTION"
const val eventExample = "EVENT_EXAMPLE"
const val miniCalculator = "MINI_CALCULATOR"
const val example1 = "EXAMPLE_1"
const val example2 = "EXAMPLE_2"
const val ticTacToeGame = "TIC_TAC_TOE_GAME"
const val fragmentIntroduction = "FRAGMENT_INTRODUCTION"
const val fragmentManagerIntro = "FRAGMENT_MANAGER_INTRO"
private lateinit var viewType: String

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.layout_assignment_practice)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            questionActivityButton.setOnClickListener { onClick(question) }

            eventExampleButton.setOnClickListener { onClick(eventExample) }

            miniCalculatorButton.setOnClickListener { onClick(miniCalculator) }

            example1Button.setOnClickListener { onClick(example1) }

            example2Button.setOnClickListener { onClick(example2) }

            ticTacToeButton.setOnClickListener { onClick(ticTacToeGame) }

            fragmentIntro.setOnClickListener { onClick(fragmentIntroduction) }

            fragmentManagerIntroduction.setOnClickListener { onClick(fragmentManagerIntro) }

        }


    }


    private fun callViewActivity() {
        val intent = Intent(this@MainActivity, ViewActivity::class.java).apply {
            putExtra(view, viewType)
        }
        startActivity(intent)
    }

    private fun onClick(view: String) {
        viewType = view
        callViewActivity()
    }
}