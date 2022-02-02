package com.example.basic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basic.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

const val view = "VIEW"
const val question = "QUESTION"
private lateinit var viewType: String

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.layout_assignment_practice)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.questionActivityButton.setOnClickListener {
            viewType = question
            onClick()
        }

    }


    private fun callViewActivity() {
        val intent = Intent(this@MainActivity, ViewActivity::class.java).apply {
            putExtra(view, viewType)
        }
        startActivity(intent)
    }

    fun onClick() {
        callViewActivity()
    }
}