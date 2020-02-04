package com.example.fragmentlab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentlab.Fragment.CustomListFragment
import com.example.fragmentlab.Fragment.DetailFragment

class MainActivity : AppCompatActivity(), CustomListFragment.CustomListFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentList = CustomListFragment()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragmentList).commit()
    }

    override fun onButtonClick(position: Int) {

    }
    private fun onItemClickListener() {
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putInt("pos", position)
        detailFragment.setArguments(bundle)
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragment_container, detailFragment).addToBackStack(null).commit()
    }
}
