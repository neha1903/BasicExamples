package com.example.basic.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.basic.controller.FragmentInteractionManager
import com.example.basic.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    interface OnMessageClickListener {
        fun onMessageClick()
    }

    var messageListener: OnMessageClickListener? = null

    private var _binding: FragmentOneBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.x
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.apply {
            showActivityMessage.setOnClickListener {
                context?.let { it1 -> FragmentInteractionManager(it1).showActivityMessage() }
            }
            // The Best Practice to use Interfaces for Interactions but right now its not working
            //TODO: Implement Message Call via Interface
            //messageListener?.onMessageClick()
        }


        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        messageListener = context as? OnMessageClickListener

        if (messageListener == null) {
            throw ClassCastException("$context must implement OnArticleSelected Listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        messageListener = null

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showFragmentMessage() {
        activity?.let {
            Toast.makeText(it, "This message is from Fragment", Toast.LENGTH_SHORT).show()
        }
    }

}