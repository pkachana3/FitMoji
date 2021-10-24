package com.example.fitmoji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import java.util.*
import kotlin.collections.ArrayList

class VotePage : Fragment(), View.OnClickListener {
    var navController: NavController? = null
    private var courseModalArrayList: ArrayList<R.drawable>? = null
    companion object {
        var cards: MutableList<Int> = mutableListOf(R.drawable.fit1, R.drawable.fit2, R.drawable.fit3,
            R.drawable.fit4,R.drawable.fit5,R.drawable.fit6,R.drawable.fit7,
            R.drawable.fit8, R.drawable.fit9, R.drawable.fit10, R.drawable.fit11,
            R.drawable.fit12, R.drawable.fit13);
        var totalLikes = 0
        var totalDislikes = 0

        var likes: MutableList<Int> = mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0);
    }
    var index = 0;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vote_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<ImageButton>(R.id.Profile).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.Feed).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.FitMaker).setOnClickListener(this)
        courseModalArrayList = ArrayList()
        courseModalArrayList!!

        view.findViewById<Button>(R.id.SwipeLeft).setOnClickListener(this)
        view.findViewById<Button>(R.id.SwipeRight).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.Profile -> navController!!.navigate(R.id.action_votePage_to_profilePage)
            R.id.Feed -> navController!!.navigate(R.id.action_votePage_to_feedPage2)
            R.id.FitMaker -> navController!!.navigate(R.id.action_votePage_to_fitMakerPage)
            R.id.SwipeLeft -> {
                if (cards.size != 0) {
                    view?.findViewById<TextView>(R.id.textView2)?.visibility = View.GONE
                    view?.findViewById<ImageView>(R.id.imageView2)?.visibility = View.VISIBLE
                    var card = cards.random()
                    view?.findViewById<ImageView>(R.id.imageView2)?.setImageResource(card)
                    cards.remove(card)
                } else {
                    view?.findViewById<ImageView>(R.id.imageView2)?.visibility = View.GONE
                    view?.findViewById<TextView>(R.id.textView2)?.visibility = View.VISIBLE
                    view?.findViewById<TextView>(R.id.textView2)?.setText("Out of Outfits!")
                }
                totalDislikes++
            }
            R.id.SwipeRight -> {
                if (cards.size != 0) {
                    view?.findViewById<TextView>(R.id.textView2)?.visibility = View.GONE
                    view?.findViewById<ImageView>(R.id.imageView2)?.visibility = View.VISIBLE
                    var card = (0..cards.size).random()
                    view?.findViewById<ImageView>(R.id.imageView2)?.setImageResource(cards[card])
                    likes.set(card, cards.get(card) + 1)
                    cards.remove(cards[card])
                } else {
                    view?.findViewById<ImageView>(R.id.imageView2)?.visibility = View.GONE
                    view?.findViewById<TextView>(R.id.textView2)?.visibility = View.VISIBLE
                    view?.findViewById<TextView>(R.id.textView2)?.setText("Out of Outfits!")
                }
            }
        }
    }
    fun getOutfitLikes(outfit: Int): Int {
        return likes[outfit]
    }
}