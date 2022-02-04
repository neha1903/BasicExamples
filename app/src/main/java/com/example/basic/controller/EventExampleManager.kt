package com.example.basic.controller

import android.content.Context
import com.example.basic.R
import com.example.basic.databinding.ActivityEventExampleBinding

class EventExampleManager(
    private val context: Context,
    private val binding: ActivityEventExampleBinding
) {

    private var counter: Int = 0

    fun initEventExampleManager() {
        updateCounterInfo()
        setButtonClick()
    }

    private fun setButtonClick() {
        binding.apply {
            button21.setOnClickListener {
                counter++
                updateCounterInfo()
            }
            enableDisableButton.apply {
                setOnClickListener {
                    if (button21.isEnabled) {
                        button21.apply {
                            isEnabled = false
                        }
                        text = context.getString(R.string.enable)

                    } else {
                        button21.apply {
                            isEnabled = true
                        }
                        text = context.getString(R.string.disable)
                    }
                }
            }
        }
    }

    private fun updateCounterInfo() {
        binding.buttonClickedInfo.text = context.getString(R.string.counter_info, counter)
    }

}