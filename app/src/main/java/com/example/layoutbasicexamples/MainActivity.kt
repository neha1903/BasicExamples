package com.example.layoutbasicexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layoutbasicexamples.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.layout_assignment_practice)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        callQuestionActivity()

    }



    private fun callQuestionActivity(){
        val intent = Intent(this@MainActivity, QuestionActivity::class.java)
        startActivity(intent)
    }
}