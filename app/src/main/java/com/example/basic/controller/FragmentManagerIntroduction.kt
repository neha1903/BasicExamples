package com.example.basic.controller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.basic.R
import com.example.basic.databinding.FragmentManagerIntroBinding
import com.example.basic.fragments.FirstFragment
import com.example.basic.fragments.SecondFragment

class FragmentManagerIntroduction(
    private val context: Context,
    private val binding: FragmentManagerIntroBinding
) {

    fun initFragmentManagerIntroductionManager() {
        binding.apply {
            addFrag.setOnClickListener {
                val fragment = FirstFragment()
                val fragmentTransaction =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.frag_container, fragment, "FirstFragment").commit()
            }

            removeFrag.setOnClickListener {
                val fragment =
                    (context as AppCompatActivity).supportFragmentManager.findFragmentById(R.id.frag_container)
                // Another Way of finding Fragment
                //val fragmentOne = (context as AppCompatActivity).supportFragmentManager.findFragmentByTag("FirstFragment")
                fragment?.let {
                    context.supportFragmentManager.beginTransaction().remove(it).commit()
                }
            }

            replaceFrag.setOnClickListener {
                val fragment = SecondFragment()

                with((context as AppCompatActivity).supportFragmentManager.beginTransaction()) {
                    replace(R.id.frag_container, fragment)
                    // The below line allows to go back to the Previous Fragment
                    addToBackStack(null)
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    commit()
                }
            }

        }
    }

}