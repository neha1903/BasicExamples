package com.example.basic.controller

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basic.R
import com.example.basic.databinding.FragmentInteractionLayoutBinding
import com.example.basic.fragments.OneFragment


class FragmentInteractionManager : OneFragment.OnMessageClickListener {
    private var context: Context
    private lateinit var binding: FragmentInteractionLayoutBinding

    constructor(context: Context, binding: FragmentInteractionLayoutBinding) {
        this.context = context
        this.binding = binding
    }

    constructor(context: Context) {
        this.context = context
    }

    fun initFragmentInteractionManager() {
        addFragmentInContainer()
    }

    private fun addFragmentInContainer() {
        val fragment = OneFragment()
        val fragmentTransaction =
            (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_container, fragment, "OneFragment").commit()

        binding.apply {
            showFragmentMessage.setOnClickListener {
                val oneFragment =
                    (context as AppCompatActivity).supportFragmentManager.findFragmentById(R.id.main_container) as OneFragment
                oneFragment.showFragmentMessage()
            }
        }

    }

    override fun onMessageClick() {
        showActivityMessage()
    }

    fun showActivityMessage() {
        Toast.makeText(context, "This message is from Activity", Toast.LENGTH_SHORT).show()
    }
}


