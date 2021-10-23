package com.example.fitmoji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

class FeedPage : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.Profile).setOnClickListener(this)
        view.findViewById<Button>(R.id.Vote).setOnClickListener(this)
        view.findViewById<Button>(R.id.FitMaker).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.Profile -> navController!!.navigate(R.id.action_feedPage_to_profilePage)
            R.id.FitMaker -> navController!!.navigate(R.id.action_feedPage_to_fitMakerPage)
            R.id.Vote -> navController!!.navigate(R.id.action_feedPage_to_votePage)
        }
    }
}