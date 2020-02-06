package com.example.fragmentlab

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

class CustomListFragment : Fragment() {
    private var activity: MainActivity? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        check(context is MainActivity)
        activity = context as MainActivity
    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayInfo(Data.presidents[0])
        rcv.apply {
            adapter = PresidentAdapter({
                displayInfo(it)
            }) { president ->
                startActivity(
                    Intent(Intent.ACTION_VIEW)
                )
            }
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun displayInfo(president: President) {
        activity?.updateTextView(president.toString())
    }
}
