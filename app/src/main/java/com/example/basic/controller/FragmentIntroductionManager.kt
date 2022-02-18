package com.example.basic.controller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.basic.R
import com.example.basic.fragments.SecondFragment

class FragmentIntroductionManager(private val context: Context) {

    fun initFragmentIntroductionManager() {
        createFragmentProgrammatically()
    }

    private fun createFragmentProgrammatically() {
        val fragment = SecondFragment()

        //  val fragmentManager = supportFragmentManager
        // The above line Works when we call Fragment Manager directly from activity

        val con = context as AppCompatActivity // this means the Context is of Activity
        val fragmentManager = con.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}