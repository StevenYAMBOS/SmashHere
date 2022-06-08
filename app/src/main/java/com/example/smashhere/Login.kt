package com.example.smashhere

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.math.sign

class Login : AppCompatActivity() {

    private lateinit var signInEmail : String
    private lateinit var signInPassword : String
    private lateinit var signUnInputArray : Array<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signUnInputArray = arrayOf(editTextTextEmailAddress,editTextTextPassword)

        //Bouton pour aller dans "Sign UP"
        btn_sign_in.setOnClickListener{
            startActivity(Intent(this, Sign_Up::class.java))
            finish()
        }

        btn_connection.setOnClickListener {
            signInUser()
        }
    }

    private fun notEmpty(): Boolean = signInEmail.isNotEmpty() && signInPassword.isNotEmpty()

    private fun signInUser(){
        signInEmail = editTextTextEmailAddress.toString().trim()
        signInPassword = editTextTextPassword.toString().trim()
    }
}
