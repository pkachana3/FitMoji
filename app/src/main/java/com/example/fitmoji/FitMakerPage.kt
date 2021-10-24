package com.example.fitmoji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

class FitMakerPage : Fragment(), View.OnClickListener {
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fit_maker_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.Profile).setOnClickListener(this)
        view.findViewById<Button>(R.id.Feed).setOnClickListener(this)
        view.findViewById<Button>(R.id.Vote).setOnClickListener(this)
        view.findViewById<Button>(R.id.BackBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.ShirtBtn).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.Profile -> navController!!.navigate(R.id.action_fitMakerPage_to_profilePage)
            R.id.Feed -> navController!!.navigate(R.id.action_fitMakerPage_to_feedPage)
            R.id.Vote -> navController!!.navigate(R.id.action_fitMakerPage_to_votePage)
            R.id.BackBtn -> {
                view?.findViewById<RadioGroup>(R.id.ShirtsGroup)!!.visibility = View.GONE
                view?.findViewById<RadioGroup>(R.id.PantsGroup)!!.visibility = View.GONE
                view?.findViewById<RadioGroup>(R.id.ShoesGroup)!!.visibility = View.GONE
            }
            R.id.ShirtBtn -> view?.findViewById<RadioGroup>(R.id.ShirtsGroup)!!.visibility = View.VISIBLE
        }
    }
}