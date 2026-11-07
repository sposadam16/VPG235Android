package com.example.week4

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MyFragment: Fragment()
{
    lateinit var listener: FragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as FragmentListener
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        val fragLayout = inflater.inflate(R.layout.fragment_layout,
            container,
            false)

        fragLayout.findViewById<Button>(R.id.removeMeButton_id).setOnClickListener {
            listener.removeFragment()
        }

        return fragLayout
    }
}