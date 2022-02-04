package com.example.basic.controller

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.basic.R
import com.example.basic.databinding.ActivityMiniCalculatorBinding


class MiniCalculatorManager(
    private val context: Context,
    private val binding: ActivityMiniCalculatorBinding
) {

    private var ans = 0

    fun initMiniCalculatorManager() {
        setButtonOnClick()
    }

    private fun setButtonOnClick() {
        binding.apply {
            addButton.setOnClickListener { doCalculation(1) }
            subtractButton.setOnClickListener { doCalculation(2) }
            multiplyButton.setOnClickListener { doCalculation(3) }
            divideButton.setOnClickListener { doCalculation(4) }
        }

    }

    private fun doCalculation(type: Int) {


        binding.apply {
            try {
                val imm =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.mainLayout.windowToken, 0)
                val number1: Int = Integer.parseInt(number1.text.toString())
                val number2: Int = Integer.parseInt(number2.text.toString())

                when (type) {
                    1 -> {
                        ans = number1 + number2
                        ansTextView.text = context.getString(R.string.addition, ans)
                    }
                    2 -> {
                        ans = number1 - number2
                        ansTextView.text = context.getString(R.string.subtraction, ans)
                    }
                    3 -> {
                        ans = number1 * number2
                        ansTextView.text = context.getString(R.string.multiplication, ans)
                    }
                    4 -> {
                        ans = number1 / number2
                        ansTextView.text = context.getString(R.string.division, ans)
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(
                    context,
                    context.getString(R.string.exception_occurred, e.message.toString()),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }


}