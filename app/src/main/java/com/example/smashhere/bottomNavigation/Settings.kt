package com.example.smashhere.bottomNavigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.smashhere.Login
import com.example.smashhere.R
import com.example.smashhere.databinding.FragmentSettingsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.core.view.View
import kotlinx.android.synthetic.main.fragment_settings.*

class Settings : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View? {

//        Pour déconnecter l'utilisateur
//        On fait appel à FireBase.Auth + signOut
        auth = FirebaseAuth.getInstance()
        auth.signOut()

//        Pour aller d'un FRAGMENT à une ACTIVITY
        val bind = FragmentSettingsBinding.inflate(layoutInflater)
        bind.logOut.setOnClickListener {
            val intent = Intent(this@Settings.requireContext(), Login::class.java)
            startActivity(intent)
        }
        return bind.root
    }
}