package com.example.fragmentlab.Fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.ListFragment
import android.support.v7.appcompat.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.view.*

class CustomListFragment : ListFragment() {
    internal var activityCallBack: CustomListFragmentListener? = null
    interface CustomListFragmentListener {
        fun onButtonClick(position: Int)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityCallBack = context as CustomListFragmentListener
        if (activityCallBack == null) {
            throw ClassCastException("$context must implement OnArticleSelectedListener")
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_list, container, false)
    }
}
