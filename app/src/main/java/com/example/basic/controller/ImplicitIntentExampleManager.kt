package com.example.basic.controller

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.basic.databinding.ImplicitIntentExampleBinding

class ImplicitIntentExampleManager(
    private val context: Context,
    private val binding: ImplicitIntentExampleBinding
) {

    fun initImplicitIntentManager() {
        onClickListener()
    }

    private fun onClickListener() {
        binding.openUrlButton.setOnClickListener {
            try {
                val url = binding.editText.text.toString().trim()
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = Uri.parse(url)
                }
                context.startActivity(intent)
                //TODO: ResolveActivity Syntax
                /*not sure how to use resolveActivity here*/
                /*if (intent.resolveActivity(context.packageManager) != null) {
                } else {
                    Toast.makeText(context, context.getString(R.string.no_activity), Toast.LENGTH_SHORT)
                        .show()
                }*/
            } catch (e: Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }
}