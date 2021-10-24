package com.example.fitmoji

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

class FitMakerPage : Fragment(), View.OnClickListener {
    var navController: NavController? = null
    var shirt = "blackshirt"
    var pant = "blackpant"
    var shoe = "blackshoe"

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
        view.findViewById<Button>(R.id.PantBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.ShoeBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.blackShirtBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.redShirtBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.blackPantBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.blackShortBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.shoeBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.sandalBtn).setOnClickListener(this)
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
                view?.findViewById<Button>(R.id.ShirtBtn)!!.visibility = View.VISIBLE
                view?.findViewById<Button>(R.id.PantBtn)!!.visibility = View.VISIBLE
                view?.findViewById<Button>(R.id.ShoeBtn)!!.visibility = View.VISIBLE
            }
            R.id.ShirtBtn -> {
                view?.findViewById<RadioGroup>(R.id.ShirtsGroup)!!.visibility = View.VISIBLE
                view?.findViewById<Button>(R.id.ShirtBtn)!!.visibility = View.GONE
                view?.findViewById<Button>(R.id.PantBtn)!!.visibility = View.GONE
                view?.findViewById<Button>(R.id.ShoeBtn)!!.visibility = View.GONE
            }
            R.id.PantBtn -> {
                view?.findViewById<RadioGroup>(R.id.PantsGroup)!!.visibility = View.VISIBLE
                view?.findViewById<Button>(R.id.ShirtBtn)!!.visibility = View.GONE
                view?.findViewById<Button>(R.id.PantBtn)!!.visibility = View.GONE
                view?.findViewById<Button>(R.id.ShoeBtn)!!.visibility = View.GONE
            }
            R.id.ShoeBtn -> {
                view?.findViewById<RadioGroup>(R.id.ShoesGroup)!!.visibility = View.VISIBLE
                view?.findViewById<Button>(R.id.ShirtBtn)!!.visibility = View.GONE
                view?.findViewById<Button>(R.id.PantBtn)!!.visibility = View.GONE
                view?.findViewById<Button>(R.id.ShoeBtn)!!.visibility = View.GONE
            }
            R.id.blackShirtBtn -> {
                shirt = "blackshirt"
                updateOutfit()
            }
            R.id.redShirtBtn -> {
                shirt = "redshirt"
                updateOutfit()
            }
            R.id.blackPantBtn -> {
                pant = "blackpant"
                updateOutfit()
            }
            R.id.blackShortBtn -> {
                pant = "blackshort"
                updateOutfit()
            }
            R.id.shoeBtn -> {
                shoe = "blackshoe"
                updateOutfit()
            }
            R.id.sandalBtn -> {
                shoe = "sandal"
                updateOutfit()
            }
        }
    }

    private fun updateOutfit() {
        if (shirt.equals("blackshirt")) {
            if (pant.equals("blackpant")) {
                if (shoe.equals("blackshoe")) {
                    view?.findViewById<ImageView>(R.id.FitMojiImg)?.setImageResource(R.drawable.man_blackshirt_blackpant_blackshoe)
                }
                else {
                    view?.findViewById<ImageView>(R.id.FitMojiImg)?.setImageResource(R.drawable.man_blackshirt_blackpant_blackshoe)
                }
            } else {
                if (shoe.equals("blackshoe")) {
                    view?.findViewById<ImageView>(R.id.FitMojiImg)?.setImageResource(R.drawable.man_blackshirt_blackshort_blackshoe)
                }
                else {
                    view?.findViewById<ImageView>(R.id.FitMojiImg)?.setImageResource(R.drawable.man_blackshirt_blackshort_sandal)
                }
            }
        } else {
            if (pant.equals("blackpant")) {
                if (shoe.equals("blackshoe")) {
                    view?.findViewById<ImageView>(R.id.FitMojiImg)?.setImageResource(R.drawable.man_redshirt_blackpant_blackshoe)
                }
                else {
                    view?.findViewById<ImageView>(R.id.FitMojiImg)?.setImageResource(R.drawable.man_redshirt_blackpant_sandal)
                }
            } else {
                if (shoe.equals("blackshoe")) {
                    view?.findViewById<ImageView>(R.id.FitMojiImg)?.setImageResource(R.drawable.man_redshirt_blackshort_blackshoe)
                }
                else {
                    view?.findViewById<ImageView>(R.id.FitMojiImg)?.setImageResource(R.drawable.man_redshirt_blackshort_sandal)
                }
            }
        }
        var src = "man_"+shirt+"_"+pant+"_"+shoe+".png"
        var drawableId = this.getResources().getIdentifier(src, "drawable", context?.getPackageName())

    }
}