package com.example.fitmoji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class ProfilePage : Fragment(), View.OnClickListener {
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.logout).setOnClickListener(this)
        view.findViewById<TextView>(R.id.liked).text = "Total Fits Liked:" + VotePage.getTotalLikes()
        view.findViewById<TextView>(R.id.disliked).text = "Total Fits Disliked:" + VotePage.getTotalDisLikes()

    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.logout -> {
                navController!!.navigate(R.id.action_profilePage_to_welcomePage)
                FirebaseAuth.getInstance().signOut()
                val providers = arrayListOf(
                    AuthUI.IdpConfig.GoogleBuilder().build(),
                    AuthUI.IdpConfig.EmailBuilder().build()
                )
                startActivityForResult(
                    AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                    123
                )
            }
        }
    }
}